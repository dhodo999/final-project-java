package DAO.Implements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import DAO.BatchDAO;
import Entity.Batch;
import Database.*;

public class BatchImplements implements BatchDAO {
    
    private final Connection connection;

    public BatchImplements(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Create a new batch
     * @param batch
     * @return batchID
     * @throws Exception
     */
    @Override
    public int createBatch(Batch batch) throws Exception {
        
        String sql = QueryHelper.INSERT_BATCH;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, batch.getProductID());
            preparedStatement.setString(2, batch.getProductName());
            preparedStatement.setDate(3, batch.getManufacturerDate());
            preparedStatement.setInt(4, batch.getQuantity());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to create supplier informations, no ID obtained.");
                }
            }
        } 
    }
    
    /**
     * Get batch by ID
     * @param batchID
     * @return batchID {int}
     * @return batchNumber {int}
     * @return batchSize {int}
     * @return batchPrice {int}
     * @return batchStatus {int}
     * @return productId {int}
     * @throws Exception
     */
    @Override
    public Batch getBatchById(int batchID) throws Exception {

        String sql = QueryHelper.SELECT_BATCH_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, batchID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Batch(
                        resultSet.getInt("batchID"),
                        resultSet.getInt("productID"),
                        resultSet.getString("productName"),
                        resultSet.getDate("manufacturerDate"),
                        resultSet.getInt("Quantity")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Get all batches
     * @return batches {List<Batch>}
     * @throws Exception
     */
    @Override
    public List<Batch> getAllBatches() throws Exception {

        List<Batch> batches = new ArrayList<>();
        String sql = QueryHelper.SELECT_BATCH;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                batches.add(new Batch(
                    resultSet.getInt("batchID"),
                    resultSet.getInt("productID"),
                    resultSet.getString("productName"),
                    resultSet.getDate("manufacturerDate"),
                    resultSet.getInt("Quantity")
                ));
            }
        }
        return batches;
    }

     /**
      * Update batch
      * @param batch
      * @return batchID
      * @throws Exception
      */
    @Override
    public void updateBatch(Batch batch) throws Exception {

        String sql = QueryHelper.UPDATE_BATCH;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, batch.getProductID());
            preparedStatement.setString(2, batch.getProductName());
            preparedStatement.setDate(3, batch.getManufacturerDate());
            preparedStatement.setInt(4, batch.getQuantity());
            preparedStatement.setInt(5, batch.getBatchID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Delete batch
     * @param batchID
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteBatch(int batchID) throws Exception {

        String sql = QueryHelper.DELETE_BATCH;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, batchID);
            preparedStatement.executeUpdate();
        }
    }
}
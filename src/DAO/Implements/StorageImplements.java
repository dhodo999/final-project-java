package DAO.Implements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import DAO.StorageDAO;
import Entity.Storage;
import Database.*;

public class StorageImplements implements StorageDAO {

    private final Connection connection;

    public StorageImplements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create a new storage
     * 
     * @param storage
     * @return storageID
     * @throws Exception
     */
    @Override
    public int createStorage(Storage storage) throws Exception {

        String sql = QueryHelper.INSERT_STORAGE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, storage.getBatchID());
            preparedStatement.setString(2, storage.getLocation());
            preparedStatement.setDate(3, storage.getStorageDate());
            preparedStatement.setInt(4, storage.getCurrentQuantity());
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
     * Get storage by ID
     * 
     * @param storageID
     * @return storageID {int}
     * @return batchID {int}
     * @return Location {String}
     * @return StorageDate {Date}
     * @return currentQuantity {int}
     * @throws Exception
     */
    @Override
    public Storage getStorageById(int storageID) throws Exception {

        String sql = QueryHelper.SELECT_STORAGE_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, storageID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Storage(
                            resultSet.getInt("storageID"),
                            resultSet.getInt("batchID"),
                            resultSet.getString("Location"),
                            resultSet.getDate("StorageDate"),
                            resultSet.getInt("currentQuantity"));
                }
            }
        }
        return null;
    }

    /**
     * Get all storage
     * 
     * @return List<Storage>
     * @throws Exception
     */
    @Override
    public List<Storage> getAllStorages() throws Exception {

        List<Storage> storageList = new ArrayList<>();
        String sql = QueryHelper.SELECT_STORAGE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Storage storage = new Storage(
                        resultSet.getInt("storageID"),
                        resultSet.getInt("batchID"),
                        resultSet.getString("Location"),
                        resultSet.getDate("StorageDate"),
                        resultSet.getInt("currentQuantity"));
                storageList.add(storage);
            }
        }
        return storageList;
    }

    /**
     * Update storage
     * 
     * @param storage
     * @throws Exception
     */
    @Override
    public void updateStorage(Storage storage) throws Exception {

        String sql = QueryHelper.UPDATE_STORAGE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, storage.getBatchID());
            preparedStatement.setString(2, storage.getLocation());
            preparedStatement.setDate(3, storage.getStorageDate());
            preparedStatement.setInt(4, storage.getCurrentQuantity());
            preparedStatement.setInt(5, storage.getStorageID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Delete storage
     * 
     * @param storageID
     * @throws Exception
     */
    @Override
    public void deleteStorage(int storageID) throws Exception {

        String sql = QueryHelper.DELETE_STORAGE;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, storageID);
            preparedStatement.executeUpdate();
        }
    }
}

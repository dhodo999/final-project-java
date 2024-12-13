package DAO.Implements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import DAO.SupplierDAO;
import Entity.Supplier;
import Database.*;

public class SupplierImplements implements SupplierDAO {

    private final Connection connection;

    public SupplierImplements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create a new supplier
     * 
     * @param supplier
     * @return supplierID
     * @throws Exception
     */
    @Override
    public int createSupplier(Supplier supplier) throws Exception {

        String sql = QueryHelper.INSERT_SUPPLIER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getContactInfo());
            preparedStatement.setString(3, supplier.getAddress());
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
     * Get supplier by ID
     * 
     * @param supplierID
     * @return supplierID {int}
     * @return supplierName {String}
     * @return contactInfo {String}
     * @return address {String}
     * @throws Exception
     */
    @Override
    public Supplier getSupplierById(int supplierID) throws Exception {

        String sql = QueryHelper.SELECT_SUPPLIER_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, supplierID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Supplier(resultSet.getInt("supplierID"),
                            resultSet.getString("supplierName"),
                            resultSet.getString("contactInfo"),
                            resultSet.getString("address"));
                }
            }
        }
        return null;
    }

    /**
     * Get all suppliers
     * 
     * @return suppliers {List<Supplier>}
     * @throws Exception
     */
    @Override
    public List<Supplier> getAllSuppliers() throws Exception {

        List<Supplier> suppliers = new ArrayList<>();
        String sql = QueryHelper.SELECT_SUPPLIER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                suppliers.add(new Supplier(resultSet.getInt("supplierID"),
                        resultSet.getString("supplierName"),
                        resultSet.getString("contactInfo"),
                        resultSet.getString("address")));
            }
        }
        return suppliers;
    }

    /**
     * Update supplier informations
     * 
     * @param supplier
     * @return void
     * @throws Exception
     */
    @Override
    public void updateSupplier(Supplier supplier) throws Exception {

        String sql = QueryHelper.UPDATE_SUPPLIER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, supplier.getSupplierName());
            preparedStatement.setString(2, supplier.getContactInfo());
            preparedStatement.setString(3, supplier.getAddress());
            preparedStatement.setInt(4, supplier.getSupplierID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Delete supplier by ID
     * 
     * @param supplierID
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteSupplier(int supplierID) throws Exception {

        String sql = QueryHelper.DELETE_SUPPLIER;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, supplierID);
            preparedStatement.executeUpdate();
        }
    }
}

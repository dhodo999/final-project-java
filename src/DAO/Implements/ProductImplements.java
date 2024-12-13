package DAO.Implements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import DAO.ProductDAO;
import Entity.Product;
import Database.*;

public class ProductImplements implements ProductDAO {

    private final Connection connection;

    public ProductImplements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create a new product
     * 
     * @param product
     * @return productID
     * @throws Exception
     */
    @Override
    public int createProduct(Product product) throws Exception {

        String sql = QueryHelper.INSERT_PRODUCT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryID());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to create product informations, no ID obtained.");
                }
            }
        }
    }

    /**
     * Get product by ID
     * 
     * @param productID
     * @return productID {int}
     * @return productName {String}
     * @return categoryID {int}
     * @return categoryName {String}
     * @return Description {String}
     * @throws Exception
     */
    @Override
    public Product getProductById(int productID) throws Exception {

        String sql = QueryHelper.SELECT_PRODUCT_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Product(resultSet.getInt("productID"),
                            resultSet.getString("productName"),
                            resultSet.getInt("categoryID"),
                            resultSet.getString("categoryName"),
                            resultSet.getString("Description"));
                }
            }
        }
        return null;
    }

    /**
     * Get all products
     * 
     * @return List<Product>
     * @throws Exception
     */
    @Override
    public List<Product> getAllProducts() throws Exception {

        List<Product> products = new ArrayList<>();
        String sql = QueryHelper.SELECT_PRODUCT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("productID"),
                        resultSet.getString("productName"),
                        resultSet.getInt("categoryID"),
                        resultSet.getString("categoryName"),
                        resultSet.getString("Description")));
            }
        }
        return products;
    }

    /**
     * Update product
     * 
     * @param product
     * @return productID
     * @throws Exception
     */
    @Override
    public void updateProduct(Product product) throws Exception {

        String sql = QueryHelper.UPDATE_PRODUCT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryID());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getProductID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Delete product
     * 
     * @param productID
     * @return productID
     * @throws Exception
     */
    @Override
    public void deleteProduct(int productID) throws Exception {

        String sql = QueryHelper.DELETE_PRODUCT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, productID);
            preparedStatement.executeUpdate();
        }
    }
}

package DAO.Implements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import DAO.CategoryDAO;
import Entity.Category;
import Database.*;

public class CategoryImplements implements CategoryDAO {

    private final Connection connection;

    public CategoryImplements(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create a new category
     * 
     * @param category
     * @return categoryID
     * @throws Exception
     */
    @Override
    public int createCategory(Category category) throws Exception {

        String sql = QueryHelper.INSERT_CATEGORY;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Failed to create category informations, no ID obtained.");
                }
            }
        }
    }

    /**
     * Get category by ID
     * 
     * @param categoryID
     * @return categoryID {int}
     * @return categoryName {String}
     * @throws Exception
     */
    @Override
    public Category getCategoryById(int categoryID) throws Exception {

        String sql = QueryHelper.SELECT_CATEGORY_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoryID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Category(resultSet.getInt("categoryID"),
                            resultSet.getString("categoryName"));
                }
            }
        }
        return null;
    }

    /**
     * Get all categories
     * 
     * @return List<Category>
     * @throws Exception
     */
    @Override
    public List<Category> getAllCategories() throws Exception {

        List<Category> categories = new ArrayList<>();
        String sql = QueryHelper.SELECT_CATEGORY;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getInt("categoryID"), resultSet.getString("categoryName")));
            }
        }
        return categories;
    }

    /**
     * Update category
     * 
     * @param category
     * @return categoryID
     * @throws Exception
     */
    @Override
    public void updateCategory(Category category) throws Exception {

        String sql = QueryHelper.UPDATE_CATEGORY;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, category.getCategoryID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Delete category
     * 
     * @param categoryID
     * @throws Exception
     */
    @Override
    public void deleteCategory(int categoryID) throws Exception {

        String sql = QueryHelper.DELETE_CATEGORY;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, categoryID);
            preparedStatement.executeUpdate();
        }
    }
}

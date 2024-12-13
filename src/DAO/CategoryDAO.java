package DAO;
import java.util.List;
import Entity.Category;

public interface CategoryDAO {

    int createCategory(Category category) throws Exception;
    Category getCategoryById(int categoryID) throws Exception;
    List<Category> getAllCategories() throws Exception;
    void updateCategory(Category category) throws Exception;
    void deleteCategory(int categoryID) throws Exception;
}

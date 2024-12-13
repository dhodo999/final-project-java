package DAO;
import java.util.List;
import Entity.Product;

public interface ProductDAO {

    int createProduct(Product product) throws Exception;
    Product getProductById(int productID) throws Exception;
    List<Product> getAllProducts() throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(int productID) throws Exception;
}

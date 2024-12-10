package Database;

public class QueryHelper {

    public static final String SELECT_PRODUCT = "SELECT p.ProductID, p.ProductName, p.CategoryID, c.CategoryName AS CategoryName, p.Description FROM products"
            + "INNER JOIN categories c ON p.CategoryID = c.CategoryID";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT p.ProductID, p.ProductName, p.CategoryID, c.CategoryName AS CategoryName, p.Description FROM products"
            + "INNER JOIN categories c ON p.CategoryID = c.CategoryID"
            + "WHERE p.ProductID = ?";
    public static final String INSERT_PRODUCT = "INSERT INTO products (ProductName, CategoryID, Description) VALUES (?, ?, ?)";
    public static final String UPDATE_PRODUCT = "UPDATE products SET ProductName = ?, CategoryID = ?, Description = ? WHERE id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";

    public static final String SELECT_CATEGORY = "SELECT * FROM categories";
    public static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM categories WHERE id = ?";
    public static final String INSERT_CATEGORY = "INSERT INTO categories (CategoryName) VALUES (?)";
    public static final String UPDATE_CATEGORY = "UPDATE categories SET CategoryName = ? WHERE id = ?";
    public static final String DELETE_CATEGORY = "DELETE FROM categories WHERE id = ?";

    public static final String SELECT_STORAGE = "SELECT * FROM storage";
    public static final String SELECT_STORAGE_BY_ID = "SELECT * FROM storage WHERE id = ?";
    public static final String INSERT_STORAGE = "INSERT INTO storage (BatchID, Location, StorageDate, CurrentQuantity) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_STORAGE = "UPDATE storage SET BatchID = ?, Location = ?, StorageDate = ?, CurrentQuantity = ? WHERE id = ?";
    public static final String DELETE_STORAGE = "DELETE FROM storage WHERE id = ?";

    public static final String SELECT_BATCH = "SELECT b.BatchID, b.ProductID, p.ProductName AS ProductName, b.ManufractureDate, b.Quantity FROM batch"
            + "INNER JOIN products p ON b.ProductID = p.ProductID";
    public static final String SELECT_BATCH_BY_ID = "SELECT b.BatchID, b.ProductID, p.ProductName AS ProductName, b.ManufractureDate, b.Quantity FROM batch"
            + "INNER JOIN products p ON b.ProductID = p.ProductID"
            + "WHERE b.BatchID = ?";
    public static final String INSERT_BATCH = "INSERT INTO batch (ProductID, ManufractureDate, Quantity) VALUES (?, ?, ?)";
    public static final String UPDATE_BATCH = "UPDATE batch SET ProductID = ?, ManufractureDate = ?, Quantity = ? WHERE id = ?";
    public static final String DELETE_BATCH = "DELETE FROM batch WHERE id = ?";

    public static final String SELECT_SUPPLIER = "SELECT * FROM suppliers";
    public static final String SELECT_SUPPLIER_BY_ID = "SELECT * FROM suppliers WHERE id = ?";
    public static final String INSERT_SUPPLIER = "INSERT INTO suppliers (SupplierName, ContactInfo, Address) VALUES (?, ?, ?)";
    public static final String UPDATE_SUPPLIER = "UPDATE suppliers SET SupplierName = ?, ContactInfo = ?, Address = ? WHERE id = ?";
    public static final String DELETE_SUPPLIER = "DELETE FROM suppliers WHERE id = ?";
}

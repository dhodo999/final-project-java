package Entity;

public class Product {

    private int productID;
    private String productName;
    private int categoryID;
    private String categoryName;
    private String Description;

    public Product(int productID, String productName, int categoryID, String categoryName, String Description) {

        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.Description = Description;
    }

    public Product(String productName, int categoryID, String categoryName, String Description) {

        this.productName = productName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.Description = Description;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", categoryID=" + categoryID
                + ", categoryName=" + categoryName + ", Description=" + Description + '}';
    }
}

package Entity;

public class Category {
    
    private int categoryID;
    private String categoryName;

    public Category(int categoryID, String categoryName) {
        
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Category(String categoryName) {
        
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + '}';
    }
}

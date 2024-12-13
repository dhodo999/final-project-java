package Entity;

import java.sql.Date;

public class Batch {

    private int batchID;
    private int productID;
    private String productName;
    private Date manufacturerDate;
    private int Quantity;

    public Batch(int batchID, int productID, String productName, Date manufacturerDate, int Quantity) {

        this.batchID = batchID;
        this.productID = productID;
        this.productName = productName;
        this.manufacturerDate = manufacturerDate;
        this.Quantity = Quantity;
    }

    public Batch(int productID, String productName, Date manufacturerDate, int Quantity) {

        this.productID = productID;
        this.productName = productName;
        this.manufacturerDate = manufacturerDate;
        this.Quantity = Quantity;
    }

    public int getBatchID() {
        return batchID;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public Date getManufacturerDate() {
        return manufacturerDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setManufacturerDate(Date manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Batch{" + "batchID=" + batchID + ", productID=" + productID + ", productName=" + productName
                + ", manufacturerDate=" + manufacturerDate + ", Quantity=" + Quantity + '}';
    }
}

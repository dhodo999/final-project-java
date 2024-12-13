package Entity;

import java.sql.Date;

public class Storage {
    
    private int storageID;
    private int batchID;
    private String Location;
    private Date StorageDate;
    private int currentQuantity;

    public Storage(int storageID, int batchID, String Location, Date StorageDate, int currentQuantity) {
        
        this.storageID = storageID;
        this.batchID = batchID;
        this.Location = Location;
        this.StorageDate = StorageDate;
        this.currentQuantity = currentQuantity;
    }

    public Storage(int batchID, String Location, Date StorageDate, int currentQuantity) {
        
        this.batchID = batchID;
        this.Location = Location;
        this.StorageDate = StorageDate;
        this.currentQuantity = currentQuantity;
    }

    public int getStorageID() {
        return storageID;
    }

    public int getBatchID() {
        return batchID;
    }

    public String getLocation() {
        return Location;
    }

    public Date getStorageDate() {
        return StorageDate;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setStorageDate(Date StorageDate) {
        this.StorageDate = StorageDate;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public String toString() {
        return "Storage{" + "storageID=" + storageID + ", batchID=" + batchID + ", Location=" + Location + ", StorageDate=" + StorageDate + ", currentQuantity=" + currentQuantity + '}';
    }
}

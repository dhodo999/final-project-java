package Entity;

public class Supplier {

    private String supplierID;
    private String supplierName;
    private String contactInfo;
    private String address;

    public Supplier(String supplierID, String supplierName, String contactInfo, String address) {

        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public Supplier(String supplierName, String contactInfo, String address) {
        
        this.supplierName = supplierName;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierID=" + supplierID + ", supplierName=" + supplierName + ", contactInfo="
                + contactInfo + ", address=" + address + '}';
    }
}

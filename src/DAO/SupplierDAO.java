package DAO;
import java.util.List;
import Entity.Supplier;

public interface SupplierDAO {

    int createSupplier(Supplier supplier) throws Exception;
    Supplier getSupplierById(int supplierID) throws Exception;
    List<Supplier> getAllSuppliers() throws Exception;
    void updateSupplier(Supplier supplier) throws Exception;
    void deleteSupplier(int supplierID) throws Exception;
}

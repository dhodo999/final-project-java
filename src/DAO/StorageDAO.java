package DAO;
import java.util.List;
import Entity.Storage;

public interface StorageDAO {

    int createStorage(Storage storage) throws Exception;
    Storage getStorageById(int storageID) throws Exception;
    List<Storage> getAllStorages() throws Exception;
    void updateStorage(Storage storage) throws Exception;
    void deleteStorage(int storageID) throws Exception;
}

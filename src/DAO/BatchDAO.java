package DAO;
import java.util.List;
import Entity.Batch;

public interface BatchDAO {

    int createBatch(Batch batch) throws Exception;
    Batch getBatchById(int batchID) throws Exception;
    List<Batch> getAllBatches() throws Exception;
    void updateBatch(Batch batch) throws Exception;
    void deleteBatch(int batchID) throws Exception;
}

package lk.ijse.gdse.dao;

import java.io.IOException;
import java.util.List;

public interface CrudDao <Entity,Id>extends SuperDao {
    boolean save(Entity entity)throws  Exception;

    boolean update(Entity entity)throws Exception;

    boolean delete(Id id)throws Exception;

    List<Entity>getAll() throws IOException;

    String genarateId() throws Exception;
}


package datos;

import dominio.ActoresDTO;
import java.sql.SQLException;
import java.util.List;


public interface ActoresDAO {
    
   public List<ActoresDTO> select() throws SQLException;
   public int insert(ActoresDTO actore) throws SQLException;
   public int update(ActoresDTO actore) throws SQLException;
   public int delete(ActoresDTO actore) throws SQLException;
    
}

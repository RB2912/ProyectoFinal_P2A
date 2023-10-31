
package datos;

import dominio.SerieDTO;
import java.sql.SQLException;
import java.util.List;


public interface SerieDAO {
    
   public List<SerieDTO> select() throws SQLException;
   public int insert(SerieDTO serie) throws SQLException;
   public int update(SerieDTO serie) throws SQLException;
   public int delete(SerieDTO serie) throws SQLException;
    
}


package datos;


import dominio.SerieDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SerieDaoJDBC implements SerieDAO {
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM series";
    private static final String SQL_INSERT = "INSERT INTO series(nombre, anio, genero, episodios, act1, act2, act3, act4) VALUES(?, ?, ?, ?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE series SET nombre=?, anio=?, genero=?, episodios=?, act1=?, act2=?, act3=?, act4=? WHERE id_serie = ?";
    private static final String SQL_DELETE = "DELETE FROM series WHERE id_serie=?";

    public SerieDaoJDBC() {

    }

    public SerieDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<SerieDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        SerieDTO serie = null;
        List<SerieDTO> series = new ArrayList<SerieDTO>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_serie = rs.getInt("id_serie");
                String nombre = rs.getString("nombre");
                int anio = rs.getInt("anio");
                String genero = rs.getString("genero");
                int episodios = rs.getInt("episodios");
                String act1 = rs.getString("act1");
                String act2 = rs.getString("act2");
                String act3 = rs.getString("act3");
                String act4 = rs.getString("act4");

                serie = new SerieDTO();
                serie.setId_serie(id_serie);
                serie.setNombre(nombre);
                serie.setAnio(anio);
                serie.setGenero(genero);
                serie.setEpisodios(episodios);
                serie.setAct1(act1);
                serie.setAct2(act2);
                serie.setAct3(act3);
                serie.setAct4(act4);
                

                series.add(serie);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return series;
    }

    public int insert(SerieDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, serie.getNombre());
            stmt.setInt(2, serie.getAnio());
            stmt.setString(3, serie.getGenero());
            stmt.setInt(4, serie.getEpisodios());
            stmt.setString(5, serie.getAct1());
            stmt.setString(6, serie.getAct2());
            stmt.setString(7, serie.getAct3());
            stmt.setString(8, serie.getAct4());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(SerieDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, serie.getNombre());
            stmt.setInt(2, serie.getAnio());
            stmt.setString(3, serie.getGenero());
            stmt.setInt(4, serie.getEpisodios());
            stmt.setString(5, serie.getAct1());
            stmt.setString(6, serie.getAct2());
            stmt.setString(7, serie.getAct3());
            stmt.setString(8, serie.getAct4());
            stmt.setInt(9, serie.getId_serie());
            
//            stmt.setString(1, serie.getNombre());
//            stmt.setString(2, usuario.getCorreo());
//            stmt.setString(3, usuario.getContrasenia());
//            stmt.setInt(4, usuario.getId());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int delete(SerieDTO serie) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, serie.getId_serie());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
             if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }
}

package datos;

import dominio.ActoresDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActoresDaoJDBC implements ActoresDAO {
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM actores";
    private static final String SQL_INSERT = "INSERT INTO actores(nombre, anios, nacionalidad, altura, ocupacion) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE actores SET nombre=?, anios=?, nacionalidad=?, altura=?, ocupacion=? WHERE id_actor = ?";
    private static final String SQL_DELETE = "DELETE FROM actores WHERE id_actor=?";

    public ActoresDaoJDBC() {

    }

    public ActoresDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<ActoresDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActoresDTO actore = null;
        List<ActoresDTO> actores = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_actor = rs.getInt("id_actor");
                String nombre = rs.getString("nombre");
                int anios = rs.getInt("anios");
                String nacionalidad = rs.getString("nacionalidad");
                int altura = rs.getInt("altura");
                String ocupacion = rs.getString("ocupacion");

                actore = new ActoresDTO();
                actore.setId_actor(id_actor);
                actore.setNombre(nombre);
                actore.setAnios(anios);
                actore.setNacionalidad(nacionalidad);
                actore.setAltura(altura);
                actore.setOcupacion(ocupacion);

                actores.add(actore);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return actores;
    }

    public int insert(ActoresDTO actore) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, actore.getNombre());
            stmt.setInt(2, actore.getAnios());
            stmt.setString(3, actore.getNacionalidad());
            stmt.setInt(4, actore.getAltura());
            stmt.setString(5, actore.getOcupacion());

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

    public int update(ActoresDTO actore) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, actore.getNombre());
            stmt.setInt(2, actore.getAnios());
            stmt.setString(3, actore.getNacionalidad());
            stmt.setInt(4, actore.getAltura());
            stmt.setString(5, actore.getOcupacion());
            stmt.setInt(6, actore.getId_actor());

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

    public int delete(ActoresDTO actore) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, actore.getId_actor());
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


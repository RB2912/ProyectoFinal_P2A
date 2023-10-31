package datos;

import dominio.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



    public class UsuarioDaoJDBC implements UsuarioDAO {
        private Connection conexionTransaccional;

        private static final String SQL_SELECT = "SELECT * FROM usuario";
        private static final String SQL_INSERT = "INSERT INTO usuario(nombre, correo, contrasenia) VALUES(?, ?, ?)";
        private static final String SQL_UPDATE = "UPDATE usuario SET nombre=?, correo=?, contrasenia=? WHERE id = ?";
        private static final String SQL_DELETE = "DELETE FROM usuario WHERE id=?";

        public UsuarioDaoJDBC() {

        }

        public UsuarioDaoJDBC(Connection conexionTransaccional) {
            this.conexionTransaccional = conexionTransaccional;
        }

        public List<UsuarioDTO> select() throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            UsuarioDTO usuario = null;
            List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
            try {
                conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_SELECT);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String correo = rs.getString("correo");
                    String contrasenia = rs.getString("contrasenia");

                    usuario = new UsuarioDTO();
                    usuario.setId(id);
                    usuario.setNombre(nombre);
                    usuario.setCorreo(correo);
                    usuario.setContrasenia(contrasenia);

                    usuarios.add(usuario);
                }
            } finally {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            }

            return usuarios;
        }

        public int insert(UsuarioDTO usuario) throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;
            int rows = 0;
            try {
                conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getCorreo());
                stmt.setString(3, usuario.getContrasenia());

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

        public int update(UsuarioDTO usuario) throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;
            int rows = 0;
            try {
                conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
                System.out.println("ejecutando query: " + SQL_UPDATE);
                stmt = conn.prepareStatement(SQL_UPDATE);
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getCorreo());
                stmt.setString(3, usuario.getContrasenia());
                stmt.setInt(4, usuario.getId());

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

        public int delete(UsuarioDTO usuario) throws SQLException {
            Connection conn = null;
            PreparedStatement stmt = null;
            int rows = 0;
            try {
                conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
                System.out.println("Ejecutando query:" + SQL_DELETE);
                stmt = conn.prepareStatement(SQL_DELETE);
                stmt.setInt(1, usuario.getId());
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


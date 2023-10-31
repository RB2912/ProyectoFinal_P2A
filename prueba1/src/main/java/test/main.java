
package test;

import datos.Conexion;
import datos.UsuarioDaoJDBC;
import dominio.UsuarioDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class main {
        public static void main(String[] args) {
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            System.out.println("SI SE PUDO CONECTAR A LA BD");
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            UsuarioDaoJDBC usuarioJdbc = new UsuarioDaoJDBC(conexion);

            UsuarioDTO cambioUsuario = new UsuarioDTO();
            cambioUsuario.setId(1);
            cambioUsuario.setNombre("Marta");
            cambioUsuario.setCorreo("marta@gmail.com");
            cambioUsuario.setContrasenia("123");
            usuarioJdbc.update(cambioUsuario);


            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
        
        


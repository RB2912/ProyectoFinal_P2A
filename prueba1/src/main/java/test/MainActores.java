package test;

import datos.ActoresDaoJDBC;
import datos.Conexion;
import dominio.ActoresDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainActores {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();

            //el autocommit por default es true, lo pasamos a false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("SE HA CONECTADO");
            }

            ActoresDaoJDBC ActoresDaoJDBC = new ActoresDaoJDBC(conexion) {
            };

            List<ActoresDTO> actores = ActoresDaoJDBC.select();

            for (ActoresDTO actore : actores) {
                System.out.println("Usuarios Registrados:" + actores);

            }
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

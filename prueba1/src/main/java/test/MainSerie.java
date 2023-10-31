
package test;

import datos.Conexion;
import datos.SerieDaoJDBC;
import dominio.SerieDTO;
import java.sql.*;
import java.util.List;

public class MainSerie {
    
    public static void main(String[] args) {
            Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            
            //el autocommit por default es true, lo pasamos a false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                System.out.println("SE HA CONECTADO");
            }

           SerieDaoJDBC SerieDaoJDBC = new SerieDaoJDBC(conexion) {};
            
            List<SerieDTO> series = SerieDaoJDBC.select();
            
         for(SerieDTO serie : series){
             System.out.println("Series Registrados:"+ series);
            
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



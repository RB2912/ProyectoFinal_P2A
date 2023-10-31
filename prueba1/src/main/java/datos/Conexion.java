package datos;

import java.sql.*;

public class Conexion {
    // Parámetros de conexión a la base de datos PostgreSQL
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/examenfinal";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "CANELA2912";

    public static Connection getConnection() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión a la base de datos cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement stmt) {
    }

    public static void close(ResultSet rs) {
    }
}



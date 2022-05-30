package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase donde programamos y establecemos la conexion a la BD
 *
 * @author IvanSM
 */
public class Conexion {

    private final String baseDatos = "circoivan";
    private final String user = "root";
    private final String pass = "carlos";
    private final String url = "jdbc:mysql://localhost:3306/" + baseDatos;
    Connection conexion = null;

    /**
     * Crea una conexion con el SGBD y la devuelve
     *
     * @return conexion
     */
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (SQLException e) {
            System.out.println("Error al conectar al SGBD");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}

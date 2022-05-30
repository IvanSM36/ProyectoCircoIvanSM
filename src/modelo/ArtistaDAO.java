package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase donde programamos los metodos consulta a la BD Artista
 *
 * @author IvanSM
 */
public class ArtistaDAO extends Conexion {

    //Metodos
    /**
     * Creamos el metodo create() para poder insertar datos en la base de datos.
     *
     * @param artista Artistaobj
     * @return boolean
     */
    public boolean create(Artista artista) {
        // Si el artista pasado es nulo no haremos nada
        if (artista != null) {
            Connection conexion = getConexion();
            String sql = "INSERT INTO artistas (nif, apellidos, nombre, nif_jefe)"
                    + "			   VALUES ( ?,      ?,        ?,      ?    )";
            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, artista.getNif());
                sentencia.setString(2, artista.getApellidos());
                sentencia.setString(3, artista.getNombre());
                sentencia.setString(4, artista.getNifJefe());
                sentencia.executeUpdate();
                conexion.close(); // Cerramos la conexion
            } catch (SQLException ex) {
                System.out.println("Error al insertar.");
                return false;
            }
        }
        System.out.println("Se ha guardado con exito.");
        return true;
    }

    /**
     * Lee los datos con la clave primaria construye un objeto con sus datos y
     * lo devuelve.
     *
     * @param artista Artistaobj
     * @return boolean
     */
    public boolean read(Artista artista) {
        String sql = "SELECT * FROM artistas WHERE upper(nif) = ?";
        try {
            Connection conexion = getConexion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, artista.getNif()); // Asignamos la clave primaria a buscar
            ResultSet rs = sentencia.executeQuery();
            // Al estar buscando por la clave primaria. solo existen dos alternativas:
            // 1. La encuentra: el resulSet tendrá un unico registro.
            // 2. No la encuentra: el resulSet estará vacio.
            if (rs.next()) { // Si hay un registro
                artista.setNombre(rs.getString("nombre"));
                artista.setApellidos(rs.getString("apellidos"));
                artista.setNifJefe(rs.getString("nif_jefe"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("Error al consultar un artista.");
            return false;
        } finally {
            try {
                conexion.close(); // cerramos la conexion
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}

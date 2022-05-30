package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Artista;
import modelo.ArtistaDAO;
import vista.VentanaArtista;
import vista.VentanaDatosArtista;

/**
 * Clase donde se programa los eventos de los botones que necesiten acceso a la
 * BD de la ventana formulario artista, Se necesitara una clase por cada metodo ya que en nuestro caso el boton
 * buscar esta en otra ventana
 *
 * @author IvanSM
 */
public class CtrlArtistaRead implements ActionListener {

    private Artista artista;
    private ArtistaDAO consulta;
    private VentanaArtista formArtista;
    private VentanaDatosArtista datosArtista;

    /**
     * Constructor para consultar los datos
     *
     * @param artista Artista obj
     * @param consulta ArtistaDAO
     * @param datosArtista VentanaDatosArtista datos Artistas
     */
    public CtrlArtistaRead(Artista artista, ArtistaDAO consulta, VentanaDatosArtista datosArtista) {
        this.artista = artista;
        this.consulta = consulta;
        this.datosArtista = datosArtista;
        this.datosArtista.btnBuscar.addActionListener(this);
    }

    //Metodos
    /**
     *
     */
    public void limpiar() {
        formArtista.txtNombre.setText(null);
        formArtista.txtApellidos.setText(null);
        formArtista.txtNif.setText(null);
    }

    /**
     * Evento para el boton buscar que busca los datos en la BD los recoge e
     * inserta en los campos correspondientes.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == datosArtista.btnBuscar) {
            artista.setNif(datosArtista.txtNif.getText());
            if (consulta.read(artista)) {
                datosArtista.txtNombre.setText(artista.getNombre());
                datosArtista.txtApellidos.setText(artista.getApellidos());
                datosArtista.txtNifJefe.setText(artista.getNifJefe());
                if (consulta.read(artista)) {
                    JOptionPane.showMessageDialog(null, "Consulta realizada.");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al consultar.");
                    limpiar();
                }
            }
        }
    }

}

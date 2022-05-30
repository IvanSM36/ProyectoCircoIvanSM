package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Artista;
import modelo.ArtistaDAO;
import vista.VentanaArtista;

/**
 * Clase donde se programa los eventos de los botones que necesiten acceso a la BD de la ventana formulario de Artistas 
 * @author IvanSM
 */
public class CtrlArtistas implements ActionListener {

    private Artista artista;
    private ArtistaDAO consultaArtista;
    private VentanaArtista formArtista;

    // Constructores
    /**
     * Constructor que conecta el objeto Artista, objetoArtistaDAO y el
     * formulario de la ventana Artista
     *
     * @param artista ArtistaObj
     * @param consultaArtista ArtistaDAO
     * @param formArtista VentanaArtista formulario artista
     */
    public CtrlArtistas(Artista artista, ArtistaDAO consultaArtista, VentanaArtista formArtista) {
        this.artista = artista;
        this.consultaArtista = consultaArtista;
        this.formArtista = formArtista;
        this.formArtista.btnGuardar.addActionListener(this);
    }

    //Metodos
    /*
    * Metodo que limpia los campos del formulario
    *@param
    *@retrun 
     */
    public void limpiar() {
        formArtista.txtNombre.setText(null);
        formArtista.txtApellidos.setText(null);
        formArtista.txtNif.setText(null);
    }

    /**
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formArtista.btnGuardar) {//Boton que hará el evento
            artista.setNombre(formArtista.txtNombre.getText());
            artista.setApellidos(formArtista.txtApellidos.getText());
            artista.setNif(formArtista.txtNif.getText()); 
            artista.setNifJefe(formArtista.lisNifJefe.getSelectedItem().toString());
            if (consultaArtista.create(artista)) {
                JOptionPane.showMessageDialog(null, "Registro insertado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar.");
                limpiar();
            }
        }

    }

}

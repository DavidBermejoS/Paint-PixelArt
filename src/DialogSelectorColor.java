import javax.swing.*;
import java.awt.*;

/**
 *
 * Clase extendida de la clase dialog, modificada para que muestre
 * una ventana de dialogo de selección de color propia.
 * @author David Bermejo Simon
 * @since 1.2.0
 **/
public class DialogSelectorColor extends JDialog {
    int red;
    int green;
    int blue;
    
    JButton okButton;
    JButton cancelButton;
    JButton resetButton;

    JFrame frame;

    /**
     * Constructor de la clase para inicializar parámetros básicos
     * @param button : botón que ha activado el dialogo
     * @param owner : ventana/frame desde la que se ha llamado al dialogo
     * @param title : titulo de la nueva ventana de dialogo
     * @param modal : modal para comprobar si se puede interactuar con la ventana inferior mientras esta este abierta.
     */
    public DialogSelectorColor(JButton button,JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.frame = owner;

        //colocamos la ventana del dialogo sobre el botón que la activo. Ademas le establecemos las medidas
        super.setBounds((int)button.getLocationOnScreen().getX(),(int)button.getLocationOnScreen().getY(),250,400);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Metodo encargado de inicializar los componentes y los listener del JDialog
     *
     */
    public void startDialog(){
        this.setVisible(true);
        inicializarComponentes();
        inicializarListeners();

    }

    public void inicializarComponentes(){



    }

    public void inicializarListeners(){

    }


}

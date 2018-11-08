import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

/**
 * Clase extendida de la clase JButton que implementa ActionListener y MouseListener.
 * Las instancias de esta clase permitiran cambiar de color paneles asociados al mismo.
 * +
 * @author David Bermejo Simon
 * @since 1.0.0
 */
public class MyButton extends JButton implements ActionListener, MouseListener {

    JPanel panelVinculate;
    JFrame windowParent;
    Color color = Color.BLACK;


    /**
     * Constructor de la clase MyButton
     * @param panelVinculate : panel vinculado al boton, el cual se cambiará el color de fondo
     * @param col : columna donde se situa el boton en la tabla
     * @param row : fila donde se situa el boton en la tabla
     */
    public MyButton(JFrame father, JPanel panelVinculate,int col, int row){
        //establecemos el nombre al botón
        super(col+"-"+row);
        //ponemos en cursiva el boton
        Font cursiva = new Font( "Arial",Font.ITALIC,15 );
        Map attributes = cursiva.getAttributes();
        this.setFont(cursiva.deriveFont(attributes));

        this.windowParent = father;
        this.panelVinculate = panelVinculate;
        this.addActionListener(this);
        this.addMouseListener(this);
    }

    /**
     * Metodo encargado de poner un color de fondo al panel asociado
     * cuando se hace click en el botón izquierdo del mouse
     * @param actionEvent : evento inciado al pulsar el botón [i][j]
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.panelVinculate.setBackground(color);
    }

    /**
     * Metodo encargado de abrir un Dialogo que nos permitirá
     * elegir el color que podemos poner de fondo al panel asociado.
     * Esto sucederá si se hace click con el botón derecho del mouse.
     * @param e : evento inciado al pulsar el botón [i][j]
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            Color newColor = JColorChooser.showDialog(this,"Elige un color",this.color);
            if(newColor!=null){
                this.color = newColor;
            }
        }
        if(SwingUtilities.isMiddleMouseButton(e)){
            DialogSelectorColor selector = new DialogSelectorColor((JButton)e.getSource(), windowParent, "Elige el color", true);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

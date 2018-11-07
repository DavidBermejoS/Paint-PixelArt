import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class MyButton extends JButton implements ActionListener, MouseListener {

    JPanel panelVinculate;
    Color color = Color.BLACK;


    public MyButton(JPanel panelVinculate,int col, int row){
        super(col+"-"+row);
        //ponemos en cursiva el boton
        Font cursiva = new Font( "Arial",Font.ITALIC,15 );
        Map attributes = cursiva.getAttributes();
        this.setFont(cursiva.deriveFont(attributes));


        this.panelVinculate = panelVinculate;
        this.addActionListener(this);
        this.addMouseListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.panelVinculate.setBackground(color);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)){
            Color newColor = JColorChooser.showDialog(this,"Elige un color",this.color);
            if(newColor!=null){
                this.color = newColor;
            }
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

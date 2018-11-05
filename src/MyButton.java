import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MyButton extends JButton implements ActionListener {

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
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.panelVinculate.setBackground(color);
    }
}

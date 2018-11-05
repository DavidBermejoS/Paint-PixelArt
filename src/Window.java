import javax.swing.*;
import java.awt.*;

/**
 * Clase que gestionará la interfaz de la ventana principal
 * @author David Bermejo Simon
 */
public class Window {
    JFrame frame;

    JPanel leftPanel;
    JPanel rightPanel;

    //paneles coloreables como píxeles
    JPanel pixelsPanel;
    JPanel [][] pixels;


    //botonera
    JPanel buttonPanel;
    MyButton[][] buttons;

    public Window(){
        frame = new JFrame("PixelArt");
        frame.setBounds(100,100,900,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Método encargado de inicializar los componentes de la interfaz
     * @since : 0.1.0
     */
    public void inicializarComponentes(){

         //inicializar componentes
        frame.setLayout(new GridBagLayout());
        GridBagConstraints settings;

        //panel izquierdo gris oscuro
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.GRAY);
        leftPanel.setLayout(new GridBagLayout());
        settings = new GridBagConstraints();
        settings.gridx = 0;
        settings.gridy = 0;
        settings.weightx = 10;
        settings.weighty = 1;
        settings.fill = GridBagConstraints.BOTH;
        frame.add(leftPanel,settings);

        //panel derecho azul cian
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.CYAN);
        rightPanel.setLayout(new GridBagLayout());
        settings = new GridBagConstraints();
        settings.gridx = 1;
        settings.gridy = 0;
        settings.weightx=1;
        settings.weighty=1;
        settings.fill = GridBagConstraints.BOTH;
        frame.add(rightPanel,settings);

        //panel de pixeles
        pixelsPanel = new JPanel();
        pixelsPanel.setLayout(new GridLayout(4,4));
        settings = new GridBagConstraints();
        settings.insets = new Insets(40,40,40,40);
        settings.fill = GridBagConstraints.BOTH;
        settings.weightx=8;
        settings.weighty=0.8;
        leftPanel.add(pixelsPanel,settings);

        //pixeles
        pixels = new JPanel[4][4];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = new JPanel();
                pixels[i][j].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                pixelsPanel.add(pixels[i][j]);
            }
        }

        //panel de botones
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Pintar Area"));

        settings = new GridBagConstraints();
        settings.insets=new Insets(80,30,80,30);
        settings.fill = GridBagConstraints.BOTH;
        settings.weightx=8;
        settings.weighty=0.8;
        rightPanel.add(buttonPanel,settings);

        //botones
        buttons = new MyButton[4][4];
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new MyButton(pixels[i][j],i,j);
                buttonPanel.add(buttons[i][j]);
            }

        }



    }


    public void inicializar(){
        this.frame.setVisible(true);
        inicializarComponentes();


    }

}

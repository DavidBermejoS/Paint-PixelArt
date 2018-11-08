import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Clase extendida de la clase dialog, modificada para que muestre
 * una ventana de dialogo de selección de color propia.
 * @author David Bermejo Simon
 * @since 1.2.0
 **/
public class DialogSelectorColor extends JDialog implements ChangeListener, ActionListener {
    int red;
    int green;
    int blue;

    JSpinner redSpinner;
    JSpinner blueSpinner;
    JSpinner greenSpinner;

    JLabel labelRed;
    JLabel labelBlue;
    JLabel labelGreen;

    JSlider redSlider;
    JSlider blueSlider;
    JSlider greenSlider;

    JPanel colorMuestra;
    Color colorReturn;

    JButton okButton;


    MyButton bAffected;
    /**
     * Constructor de la clase para inicializar parámetros básicos
     * @param button : botón que ha activado el dialogo
     * @param owner : ventana/frame desde la que se ha llamado al dialogo
     * @param title : titulo de la nueva ventana de dialogo
     * @param modal : modal para comprobar si se puede interactuar con la ventana inferior mientras esta este abierta.
     */
    public DialogSelectorColor(JButton button,JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        bAffected = (MyButton)button;

        //colocamos la ventana del dialogo sobre el botón que la activo. Ademas le establecemos las medidas
        super.setBounds((int)button.getLocationOnScreen().getX()-10,(int)button.getLocationOnScreen().getY(),350,450);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //inicializar los componentes y los listeners, además de hacer la ventana visible
        addComponents();
        addListener();
        this.setVisible(true);
    }


    /**
     * Metodo encargado de inicializar los componentes en la interfaz
     */
    public void addComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints settings = new GridBagConstraints();

        //config valor red
        //label red
        labelRed = new JLabel("Cantidad de Rojo");
        settings = new GridBagConstraints();
        settings.gridy=0;
        settings.ipadx=10;
        settings.ipady=10;
        settings.gridwidth=2;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelRed,settings);

        //slider red
        redSlider = new JSlider();
        redSlider.setMajorTickSpacing(10);
        redSlider.setMinorTickSpacing(0);
        redSlider.setMaximum(255);
        redSlider.setMinimum(0);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(false);
        settings = new GridBagConstraints();
        settings.gridy=1;
        settings.gridx=0;
        settings.ipadx=10;
        settings.ipady=10;
        settings.gridwidth=2;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(redSlider,settings);

        //spinner red
        SpinnerModel sm1 = new SpinnerNumberModel(0, 0, 255, 1);
        redSpinner = new JSpinner(sm1);
        settings = new GridBagConstraints();
        settings.gridy=2;
        settings.gridx=0;
        settings.ipadx=10;
        settings.ipady=10;
        settings.gridwidth=2;

        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(redSpinner,settings);


        // config valor green
        //label green
        labelGreen = new JLabel("Cantidad de Verde");
        settings = new GridBagConstraints();
        settings.gridy=3;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelGreen,settings);

        //slider green
        greenSlider = new JSlider();
        greenSlider.setMajorTickSpacing(10);
        greenSlider.setMinorTickSpacing(0);
        greenSlider.setMaximum(255);
        greenSlider.setMinimum(0);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(false);
        settings = new GridBagConstraints();
        settings.gridy=4;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(greenSlider,settings);

        //spinner green
        SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 255, 1);
        greenSpinner = new JSpinner(sm2);
        settings = new GridBagConstraints();
        settings = new GridBagConstraints();
        settings.gridy=5;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(greenSpinner,settings);



        // config valor blue
        //label blue
        labelBlue = new JLabel("Cantidad de Azul");
        settings = new GridBagConstraints();
        settings = new GridBagConstraints();
        settings.gridy=6;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelBlue,settings);

        //blue slider
        blueSlider = new JSlider();
        blueSlider.setMajorTickSpacing(10);
        blueSlider.setMinorTickSpacing(0);
        blueSlider.setMaximum(255);
        blueSlider.setMinimum(0);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(false);
        settings = new GridBagConstraints();
        settings.gridy=7;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(blueSlider,settings);

        //blue spinner
        SpinnerModel sm3 = new SpinnerNumberModel(0, 0, 255, 1);
        blueSpinner = new JSpinner(sm3);
        settings = new GridBagConstraints();
        settings.gridy=8;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(blueSpinner,settings);



        //panel que muestra el color.
        colorMuestra = new JPanel();
        colorMuestra.setBorder(BorderFactory.createLineBorder(Color.GRAY,3));
        settings = new GridBagConstraints();
        settings.gridy=9;
        settings.gridwidth=2;
        settings.ipadx=200;
        settings.ipady=25;
        settings.fill = GridBagConstraints.HORIZONTAL;
        settings.insets = new Insets(10,0,10,0);
        this.add(colorMuestra,settings);



        //boton aceptar
        okButton = new JButton("Ok!");
        settings.gridy=10;
        settings.ipadx=10;
        settings.ipady=10;
        settings.fill = GridBagConstraints.HORIZONTAL;
        this.add(okButton,settings);
    }

    public void addListener(){
        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);

        redSpinner.addChangeListener(this);
        greenSpinner.addChangeListener(this);
        blueSpinner.addChangeListener(this);

        okButton.addActionListener(this);

    }


    /**
     * Metoodo encargado de recibir los cambios de los Sliders
     * @param e : evento iniciado
     */

    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof JSlider){
            red = redSlider.getValue();
            blue = blueSlider.getValue();
            green = greenSlider.getValue();
            redSpinner.setValue(red);
            blueSpinner.setValue(blue);
            greenSpinner.setValue(green);
            colorReturn = new Color (red,green,blue);
            colorMuestra.setBackground(colorReturn);
        }
        else if(e.getSource() instanceof JSpinner){
            red = (Integer) redSpinner.getValue();
            blue = (Integer)blueSpinner.getValue();
            green = (Integer)greenSpinner.getValue();
            redSlider.setValue(red);
            blueSlider.setValue(blue);
            greenSlider.setValue(green);
            colorReturn = new Color (red,green,blue);
            colorMuestra.setBackground(colorReturn);
        }

    }

    /**
     * Metodo que se encarga de devolver el color al botón que activo el dialogo
     */
    public void returnColor(){
        if(this.colorReturn!=null){
            this.bAffected.color=this.colorReturn;
        }
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        returnColor();
    }
}

package pl.jtimersk;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public static JLabel tf;


    public TopPanel() {



        setLayout(null);
        setOpaque(true);
        setBounds(0,0,360,40);
        setBackground(Colors.BUTTON_NORMAL);

        tf = new JLabel();
        tf.setLayout(null);
        tf.setOpaque(true);
        tf.setBackground(null);
        tf.setForeground(Colors.BUTTON_FONT);
        tf.setBounds(5,5,340,30);
        tf.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,16));
        add(tf);


    }
}

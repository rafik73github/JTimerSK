package pl.timersk;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TopPanel extends JPanel {

    public static JLabel tf;
    Colors col = new Colors();


    public TopPanel() throws IOException {



        setLayout(null);
        setOpaque(true);
        setBounds(0,0,360,40);
        setBackground(col.buttonNormal);

        tf = new JLabel();
        tf.setLayout(null);
        tf.setOpaque(true);
        tf.setBackground(null);
        tf.setForeground(col.buttonFont);
        tf.setBounds(5,5,340,30);
        tf.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,16));
        add(tf);


    }
}

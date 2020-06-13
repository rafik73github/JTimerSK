package pl.timersk;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    Colors col = new Colors();
    public BottomPanel(){

        setLayout(null);
        setOpaque(true);
        setBounds(0,200,360,40);
        setBackground(col.buttonFont);

    }

}

package pl.timersk;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MENU GŁÓWNE");
        setVisible(true);
        setLocation(10,10);
        setSize(500,288);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //setLayout(null);

        JScrollPane sc = new JScrollPane(new JTextArea(15, 15));
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sc.setVisible(true);
        add(sc);



    }
}

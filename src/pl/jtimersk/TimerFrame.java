package pl.jtimersk;

import javax.swing.*;
import java.awt.*;


public class TimerFrame extends JFrame {


    public TimerFrame() throws Exception {

        //setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TimerSK");
        setSize(375,270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setIconImage(Resources.ICON_IMG);
        setLayout(null);
        setVisible(true);

        JPanel topPanel = new TopPanel();
        JPanel centerPanel = new CenterPanel();
        JPanel bottomPanel = new BottomPanel();

        add(topPanel);
        add(centerPanel);
        add(bottomPanel);




    }


}

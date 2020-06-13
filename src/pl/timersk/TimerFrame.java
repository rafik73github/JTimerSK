package pl.timersk;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class TimerFrame extends JFrame {

    BufferedImage iconImg = ImageIO.read(MainFrame.class.getResourceAsStream("/timersala.png"));

    public TimerFrame() throws IOException {

        //setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TimerSK");
        setSize(365,270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setIconImage(iconImg);
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

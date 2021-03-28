package pl.jtimersk;

import javax.swing.*;
import java.awt.*;

public class BadPass extends JFrame{

    public BadPass(){

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Błąd logowania");
        setSize(375,270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setIconImage(Resources.ICON_IMG);
        setLayout(null);
        setVisible(true);

        JLabel monitBadPass = new JLabel("NIEPRAWIDŁOWE HASŁO !" , SwingConstants.CENTER);
        monitBadPass.setOpaque(true);
        monitBadPass.setBounds(0, 10, 360, 140);
        monitBadPass.setBackground(null);
        monitBadPass.setForeground(Colors.BUTTON_RED_HOVER);
        monitBadPass.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        add(monitBadPass);


        JButton exitButton = new JButton("ZAMKNIJ");
        exitButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        exitButton.setOpaque(true);
        exitButton.setBounds(10, 150, 340, 44);
        exitButton.setBackground(Colors.BUTTON_RED);
        exitButton.setForeground(Colors.BUTTON_FONT);
        exitButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_RED, 1));
        exitButton.setFocusable(false);
        add(exitButton);
        new PanelsTools().buttonHoverSet(exitButton, Colors.BUTTON_RED, Colors.BUTTON_RED_HOVER, Colors.BUTTON_RED, true);

        exitButton.addActionListener(e -> {
            setVisible(false);
            new FirstFrame();
        });






    }
}

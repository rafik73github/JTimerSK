package pl.jtimersk;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.security.NoSuchAlgorithmException;


public class FirstFrame extends JFrame {


    char[] passwordText;

    public FirstFrame() {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TimerSK");
        setSize(375, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setIconImage(Resources.ICON_IMG);
        setLayout(null);
        setVisible(true);

        JLabel passTitle = new JLabel("WPROWADŹ HASŁO" , SwingConstants.CENTER);
        passTitle.setOpaque(true);
        passTitle.setBounds(0, 20, 360, 25);
        passTitle.setBackground(null);
        passTitle.setForeground(Colors.BUTTON_DISABLED);
        passTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        add(passTitle);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(10,50,340, 30);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        add(passwordField);

        JButton okPassButton = new JButton("OK");
        okPassButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        okPassButton.setOpaque(true);
        okPassButton.setBounds(10, 100, 163, 44);
        okPassButton.setBackground(Colors.BUTTON_RED);
        okPassButton.setForeground(Colors.BUTTON_FONT);
        okPassButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_RED, 1));
        okPassButton.setFocusable(false);
        add(okPassButton);
        new PanelsTools().buttonHoverSet(okPassButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_RED, true);

        JButton exitPassButton = new JButton("ZAKOŃCZ");
        exitPassButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        exitPassButton.setOpaque(true);
        exitPassButton.setBounds(185, 100, 163, 44);
        exitPassButton.setBackground(Colors.BUTTON_RED);
        exitPassButton.setForeground(Colors.BUTTON_FONT);
        exitPassButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_RED, 1));
        exitPassButton.setFocusable(false);
        add(exitPassButton);
        new PanelsTools().buttonHoverSet(exitPassButton, Colors.BUTTON_RED, Colors.BUTTON_RED_HOVER, Colors.BUTTON_RED, true);

        okPassButton.addActionListener(e -> {

            JSONObject toCheck = new JSONObject();

            StringBuilder sb = new StringBuilder();

            passwordText = passwordField.getPassword();

            for (char chr : passwordText) {
                sb.append(chr);
            }

            try {
                toCheck.put("tokenCheck", new Security().hashMeString(sb.toString()));
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }

            try {
                if(InternetCheck.isReachable()) {

                    if (InternetCheck.checkToken(toCheck)) {

                        new PreferencesTools().setPreference("CodeName", new Security().hashMeString(sb.toString()));
                        setVisible(false);
                        new TimerFrame();
                    } else {
                        setVisible(false);
                        new BadPass();

                    }

                }else{
                    setVisible(false);
                    new NoInternetFrame();
                }
            } catch (Exception ioException) {
                ioException.printStackTrace();
            }
        });

            exitPassButton.addActionListener(e -> System.exit(0));

    }

}

package pl.timersk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    Security sec = new Security();

    public LoginFrame() {

       // super("LOGOWANIE");
        setResizable(false);
        String systemName = (System.getProperty("os.name"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOGOWANIE  na systemie: (" + systemName + ")");
        setVisible(true);
        //setLocation(700,300);
        setSize(500,288);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(null);


        JPanel loginPanel = new JPanel();
        loginPanel.setBounds(0,0,485,190);
        loginPanel.setOpaque(true);
        loginPanel.setBackground(new Color(70,70,70));
        loginPanel.setLayout(null);
        add(loginPanel);

        JLabel titleLabel = new JLabel("LOGOWANIE DO BAZY DANYCH",SwingConstants.CENTER);
        titleLabel.setBounds(0,0,485,60);
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        titleLabel.setForeground(new Color(255,255,255));
        loginPanel.add(titleLabel);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(40,65,80,30);
        loginLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        loginLabel.setForeground(new Color(255,110,0));
        loginPanel.add(loginLabel);

        JLabel passLabel = new JLabel("HASŁO:");
        passLabel.setBounds(40,120,80,30);
        passLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        passLabel.setForeground(new Color(255,110,0));
        loginPanel.add(passLabel);

        JTextArea loginText = new JTextArea();
        //loginText.requestFocusInWindow();
        loginText.setBounds(110,69,285,25);
        loginText.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        loginPanel.add(loginText);



        JPasswordField passText = new JPasswordField();
        passText.setBounds(110,124,285,25);
        passText.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        loginPanel.add(passText);

        JLabel monitLabel = new JLabel("",SwingConstants.CENTER);
        monitLabel.setBounds(0,160,485,20);
        monitLabel.setOpaque(true);
        monitLabel.setBackground(new Color(255,0,0));
        monitLabel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        monitLabel.setForeground(new Color(255,255,255));
        monitLabel.setVisible(false);
        loginPanel.add(monitLabel);

        JButton buttonLogOK = new JButton("ZALOGUJ");
        buttonLogOK.setBounds(0,190,243,60);
        buttonLogOK.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        buttonLogOK.setBackground(new Color(70,130,180));
        buttonLogOK.setForeground(new Color(255,255,255));
        add(buttonLogOK);

        JButton buttonLogCancel = new JButton("CANCEL");
        buttonLogCancel.setBounds(243,190,242,60);
        buttonLogCancel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        buttonLogCancel.setBackground(new Color(220,20,60));
        buttonLogCancel.setForeground(new Color(255,255,255));
        add(buttonLogCancel);


        //this code set focus on load window
/*
        addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                passText.requestFocus();
            }
        });
*/
        // this code move focus on TAB press
        loginText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiersEx() > 0) {
                        loginText.transferFocusBackward();
                    } else {
                        loginText.transferFocus();
                    }
                    e.consume();
                }
            }
        });

        passText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonLogOK.doClick();
                    e.consume();
                }
            }
        });

        loginText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buttonLogOK.doClick();
                    e.consume();
                }
            }
        });

        loginText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    buttonLogCancel.doClick();
                    e.consume();
                }
            }
        });

        passText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    buttonLogCancel.doClick();
                    e.consume();
                }
            }
        });

        buttonLogOK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    buttonLogCancel.doClick();
                    e.consume();
                }
            }
        });


        buttonLogOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                String inputLoginText = loginText.getText();
                char[] inputPassText = passText.getPassword();

                if(inputLoginText.trim().equals("") && inputPassText.length == 0){
                    monitLabel.setText("POLA 'LOGIN' I 'HASŁO' NIE MOGĄ BYĆ PUSTE !");
                    monitLabel.setVisible(true);
                }
                else if(inputLoginText.trim().equals("")) {
                    monitLabel.setText("POLE 'LOGIN' NIE MOŻE BYĆ PUSTE !");
                    monitLabel.setVisible(true);
                }
                else if(inputPassText.length == 0){
                    monitLabel.setText("POLE 'HASŁO' NIE MOŻE BYĆ PUSTE !");
                    monitLabel.setVisible(true);
                }else {
                    monitLabel.setText("");
                    if(monitLabel.isVisible()){monitLabel.setVisible(false);}
                    try {
                        check = sec.userValidated(inputLoginText, inputPassText);
                    } catch (NoSuchAlgorithmException | SQLException noSuchAlgorithmException) {
                        noSuchAlgorithmException.printStackTrace();
                    }
                    if(!check){
                        monitLabel.setText("NIEWŁAŚCIWY LOGIN LUB HASŁO !");
                        if(!monitLabel.isVisible()){monitLabel.setVisible(true);}
                    }
                    else{
                        loginText.setText("");
                        passText.setText("");
                       // dispose();
                        //new TestFrame();
                    }
                }

                System.out.println(check);
            }
        });

        buttonLogCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}

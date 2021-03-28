package pl.jtimersk;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class NoInternetFrame extends JFrame {


    public NoInternetFrame(){

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TimerSK");
        setSize(375,270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setIconImage(Resources.ICON_IMG);
        setLayout(null);
        setVisible(true);

        JLabel monitNoInternet = new JLabel("BRAK INTERNETU" , SwingConstants.CENTER);
        monitNoInternet.setOpaque(true);
        monitNoInternet.setBounds(0, 10, 360, 70);
        monitNoInternet.setBackground(null);
        monitNoInternet.setForeground(Colors.BUTTON_RED_HOVER);
        monitNoInternet.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
        add(monitNoInternet);

        JLabel monitWaitFor1 = new JLabel("POCZEKAJ NA POŁĄCZENIE" , SwingConstants.CENTER);
        monitWaitFor1.setOpaque(true);
        monitWaitFor1.setBounds(0, 80, 360, 25);
        monitWaitFor1.setBackground(null);
        monitWaitFor1.setForeground(Colors.BUTTON_DISABLED);
        monitWaitFor1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        add(monitWaitFor1);

        JLabel monitWaitFor2 = new JLabel("LUB ZAKOŃCZ" , SwingConstants.CENTER);
        monitWaitFor2.setOpaque(true);
        monitWaitFor2.setBounds(0, 110, 360, 25);
        monitWaitFor2.setBackground(null);
        monitWaitFor2.setForeground(Colors.BUTTON_DISABLED);
        monitWaitFor2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        add(monitWaitFor2);


        JButton exitButton = new JButton("ZAKOŃCZ");
        exitButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        exitButton.setOpaque(true);
        exitButton.setBounds(10, 150, 340, 44);
        exitButton.setBackground(Colors.BUTTON_RED);
        exitButton.setForeground(Colors.BUTTON_FONT);
        exitButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_RED, 1));
        exitButton.setFocusable(false);
        add(exitButton);
        new PanelsTools().buttonHoverSet(exitButton, Colors.BUTTON_RED, Colors.BUTTON_RED_HOVER, Colors.BUTTON_RED, true);

        exitButton.addActionListener(e -> System.exit(0));

        Timer waitForInternet = new Timer();
        int begin = 0;
        int timeInterval = 5000;
        waitForInternet.schedule(new TimerTask() {

            @Override
            public void run() {
                try {
                    if (InternetCheck.isReachable()){
                    waitForInternet.cancel();
                        waitForInternet.purge();
                        setVisible(false);
                        EventQueue.invokeLater(() -> {
                            try {
                                new FirstFrame();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, begin, timeInterval);



    }

}

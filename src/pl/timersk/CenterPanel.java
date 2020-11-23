package pl.timersk;


import javax.swing.*;
import java.awt.*;


public class CenterPanel extends JPanel {
    ParseJSON parseJSON = new ParseJSON();
    private int m;
    private int s;
    private static String zeroM;
    private static String zeroS;
    private int timeToDisplayColumn = 0;
    private int timerCountDown = 0;

     final Object[][] timeToDisplay;


    PanelsTools panelTool = new PanelsTools();


    public CenterPanel() throws Exception {
        setLayout(null);
        setOpaque(true);
        setBounds(0, 40, 360, 160);
        setBackground(Color.WHITE);

        timeToDisplay = parseJSON.meetingArray();

        if(timeToDisplay == null){
            JLabel eventText = new JLabel("BŁĄD DANYCH" , SwingConstants.CENTER);
            eventText.setOpaque(true);
            eventText.setBounds(0, 10, 350, 70);
            eventText.setBackground(null);
            eventText.setForeground(Colors.BUTTON_RED_HOVER);
            eventText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
            add(eventText);
        }


        else if(timeToDisplay[0][0].equals(0) && timeToDisplay[0][1].equals(0)){
            JLabel eventText = new JLabel((String) timeToDisplay[0][2], SwingConstants.CENTER);
            eventText.setOpaque(true);
            eventText.setBounds(0, 10, 350, 70);
            eventText.setBackground(null);
            eventText.setForeground(Colors.BUTTON_NORMAL_HOVER);
            eventText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
            add(eventText);
        }
        else {


            JPanel timerDigitPanel = new JPanel();
            timerDigitPanel.setLayout(null);
            timerDigitPanel.setOpaque(true);
            timerDigitPanel.setBounds(10, 11, 290, 90);
            timerDigitPanel.setBackground(new Color(5, 5, 5));
            add(timerDigitPanel);

            String g = String.valueOf(timeToDisplay[timeToDisplayColumn][2]);
            TopPanel.tf.setText(g);

            m = (int) timeToDisplay[timeToDisplayColumn][0];
            s = (int) timeToDisplay[timeToDisplayColumn][1];

            zeroS = "0";
            zeroM = "0";
            if (m > 9) {
                zeroM = "";
            } else {
                zeroM = "0";
            }
            if (s > 9) {
                zeroS = "";
            } else {
                zeroS = "0";
            }
            String dateString = String.format(zeroM + "%d:" + zeroS + "%d", m, s);
            JLabel bigDigits = new JLabel(dateString, SwingConstants.CENTER);
            bigDigits.setOpaque(true);
            bigDigits.setBounds(10, 10, 270, 70);
            bigDigits.setBackground(null);
            bigDigits.setForeground(Colors.BIG_DIGITS_COLOR_GREEN);
            bigDigits.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 82));
            timerDigitPanel.add(bigDigits);

            JButton plusMinuteButton = new JButton(Resources.PLUS_ICON);
            plusMinuteButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            plusMinuteButton.setOpaque(true);
            plusMinuteButton.setBounds(305, 11, 44, 44);
            plusMinuteButton.setBackground(Colors.BUTTON_NORMAL);
            plusMinuteButton.setForeground(Colors.BUTTON_FONT);
            plusMinuteButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_NORMAL, 1));
            plusMinuteButton.setFocusable(false);
            add(plusMinuteButton);
            panelTool.buttonHoverSet(plusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);

            JButton minusMinuteButton = new JButton(Resources.MINUS_ICON);
            minusMinuteButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            minusMinuteButton.setOpaque(true);
            minusMinuteButton.setBounds(305, 57, 44, 44);
            minusMinuteButton.setBackground(Colors.BUTTON_NORMAL);
            minusMinuteButton.setForeground(Colors.BUTTON_FONT);
            minusMinuteButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_NORMAL, 1));
            minusMinuteButton.setFocusable(false);
            add(minusMinuteButton);
            panelTool.buttonHoverSet(minusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);

            JButton nextPointButton = new JButton(Resources.FORWARD_ICON);
            nextPointButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            nextPointButton.setOpaque(true);
            nextPointButton.setBounds(305, 106, 44, 44);
            nextPointButton.setBackground(Colors.BUTTON_NORMAL);
            nextPointButton.setForeground(Colors.BUTTON_FONT);
            nextPointButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_NORMAL, 1));
            nextPointButton.setFocusable(false);
            add(nextPointButton);
            panelTool.buttonHoverSet(nextPointButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);

            JButton startPointButton = new JButton(Resources.PLAY_ICON);
            startPointButton.setOpaque(true);
            startPointButton.setBounds(10, 106, 290, 44);
            startPointButton.setBackground(Colors.BUTTON_NORMAL);
            startPointButton.setForeground(Colors.BUTTON_FONT);
            startPointButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_NORMAL, 1));
            startPointButton.setFocusable(false);

            add(startPointButton);
            panelTool.buttonHoverSet(startPointButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);

            JButton stopPointButton = new JButton(Resources.STOP_ICON);
            stopPointButton.setVisible(false);
            stopPointButton.setOpaque(true);
            stopPointButton.setBounds(10, 106, 290, 44);
            stopPointButton.setBackground(Colors.BUTTON_RED);
            stopPointButton.setForeground(Colors.BUTTON_FONT);
            stopPointButton.setBorder(BorderFactory.createLineBorder(Colors.BUTTON_RED, 1, true));
            stopPointButton.setFocusable(false);
            add(stopPointButton);
            panelTool.buttonHoverSet(stopPointButton, Colors.BUTTON_RED, Colors.BUTTON_RED_HOVER, Colors.BUTTON_DISABLED, true);

            Timer timer = new Timer(1000, e -> {
                if (m > 9) {
                    zeroM = "";
                } else {
                    zeroM = "0";
                }
                if (s > 9) {
                    zeroS = "";
                } else {
                    zeroS = "0";
                }
                String dateString1 = String.format(zeroM + "%d:" + zeroS + "%d", m, s);

                if (m == 0 && s <= 30 && timerCountDown == 0) {
                    bigDigits.setForeground(Colors.BIG_DIGITS_COLOR_YELLOW);
                    timerCountDown = 1;
                } else if (m == 0 && s == 0 && timerCountDown == 1) {
                    bigDigits.setForeground(Colors.BIG_DIGITS_COLOR_RED);
                    timerCountDown = 2;
                }
                if (timerCountDown == 0 || timerCountDown == 1) {
                    s--;
                    if (s < 0) {
                        s = 59;
                        m--;
                    }
                } else {
                    s++;
                    if (s > 59) {
                        m++;
                        s = 0;
                    }
                }
                bigDigits.setText(dateString1);
            });

            startPointButton.addActionListener(e -> {
                startPointButton.setVisible(false);
                stopPointButton.setVisible(true);
                timer.start();
                panelTool.buttonHoverSet(minusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, false);
                panelTool.buttonHoverSet(plusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, false);
                panelTool.buttonHoverSet(nextPointButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, false);
            });

            stopPointButton.addActionListener(e -> {
                stopPointButton.setVisible(false);
                startPointButton.setVisible(true);
                timer.stop();
                panelTool.buttonHoverSet(minusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);
                panelTool.buttonHoverSet(plusMinuteButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);
                panelTool.buttonHoverSet(nextPointButton, Colors.BUTTON_NORMAL, Colors.BUTTON_NORMAL_HOVER, Colors.BUTTON_DISABLED, true);
                timerCountDown = 0;
                int len = timeToDisplay.length;

                timeToDisplayColumn++;

                if (timeToDisplayColumn < len) {
                    bigDigits.setText(zeroAdd());
                    bigDigits.setForeground(Colors.BIG_DIGITS_COLOR_GREEN);
                    TopPanel.tf.setText(String.valueOf(timeToDisplay[timeToDisplayColumn][2]));
                }

                System.out.println(len + " - " + timeToDisplayColumn);
            });

            nextPointButton.addActionListener(e -> {
                int len = timeToDisplay.length;
                timeToDisplayColumn++;

                if (timeToDisplayColumn < len) {

                    bigDigits.setText(zeroAdd());
                    bigDigits.setForeground(Colors.BIG_DIGITS_COLOR_GREEN);
                    TopPanel.tf.setText(String.valueOf(timeToDisplay[timeToDisplayColumn][2]));
                }
            });
        }
    }  //class

    public String zeroAdd(){
        m = (int)timeToDisplay[timeToDisplayColumn][0];
        s = (int)timeToDisplay[timeToDisplayColumn][1];

        if(m>9){zeroM = "";}else{zeroM = "0";}
        if(s>9){zeroS = "";}else{zeroS = "0";}

        return String.format(zeroM+"%d:"+zeroS+"%d",m,s);
    }



    }







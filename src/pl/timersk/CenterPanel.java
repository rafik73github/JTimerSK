package pl.timersk;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class CenterPanel extends JPanel {
    ParseJSON parseJSON = new ParseJSON();
    private int m;
    private int s;
    private static String zeroM;
    private static String zeroS;
    private int timeToDisplayColumn = 0;
    private int timerCountDown = 0;
    //private final int[][] timeToDisplay;
     final Object[][] timeToDisplay;
     //final JLabel bigDigits;

    Colors col = new Colors();
    PanelsTools panelTool = new PanelsTools();
    Resources resources = new Resources();


    public CenterPanel() throws IOException {
        setLayout(null);
        setOpaque(true);
        setBounds(0, 40, 350, 160);
        setBackground(Color.WHITE);

        timeToDisplay = parseJSON.meetingArray();
        if(timeToDisplay[0][0].equals(0) && timeToDisplay[0][1].equals(0)){
            JLabel eventText = new JLabel((String) timeToDisplay[0][2], SwingConstants.CENTER);
            eventText.setOpaque(true);
            eventText.setBounds(0, 10, 350, 70);
            eventText.setBackground(null);
            eventText.setForeground(col.buttonNormalHover);
            eventText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 36));
            add(eventText);
        }
        else {


            JPanel timerDigitPanel = new JPanel();
            timerDigitPanel.setLayout(null);
            timerDigitPanel.setOpaque(true);
            timerDigitPanel.setBounds(10, 11, 280, 90);
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
            bigDigits.setBounds(10, 10, 260, 70);
            bigDigits.setBackground(null);
            bigDigits.setForeground(col.bigDigitsColorGreen);
            bigDigits.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 82));
            timerDigitPanel.add(bigDigits);

            JButton plusMinuteButton = new JButton(resources.plusIcon);
            plusMinuteButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            plusMinuteButton.setOpaque(true);
            plusMinuteButton.setBounds(295, 11, 44, 44);
            plusMinuteButton.setBackground(col.buttonNormal);
            plusMinuteButton.setForeground(col.buttonFont);
            plusMinuteButton.setBorder(BorderFactory.createLineBorder(col.buttonNormal, 1));
            plusMinuteButton.setFocusable(false);
            add(plusMinuteButton);
            panelTool.buttonHoverSet(plusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);

            JButton minusMinuteButton = new JButton(resources.minusIcon);
            minusMinuteButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            minusMinuteButton.setOpaque(true);
            minusMinuteButton.setBounds(295, 57, 44, 44);
            minusMinuteButton.setBackground(col.buttonNormal);
            minusMinuteButton.setForeground(col.buttonFont);
            minusMinuteButton.setBorder(BorderFactory.createLineBorder(col.buttonNormal, 1));
            minusMinuteButton.setFocusable(false);
            add(minusMinuteButton);
            panelTool.buttonHoverSet(minusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);

            JButton nextPointButton = new JButton(resources.forwardIcon);
            nextPointButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
            nextPointButton.setOpaque(true);
            nextPointButton.setBounds(295, 106, 44, 44);
            nextPointButton.setBackground(col.buttonNormal);
            nextPointButton.setForeground(col.buttonFont);
            nextPointButton.setBorder(BorderFactory.createLineBorder(col.buttonNormal, 1));
            nextPointButton.setFocusable(false);
            add(nextPointButton);
            panelTool.buttonHoverSet(nextPointButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);

            JButton startPointButton = new JButton(resources.playIcon);
            startPointButton.setOpaque(true);
            startPointButton.setBounds(10, 106, 280, 44);
            startPointButton.setBackground(col.buttonNormal);
            startPointButton.setForeground(col.buttonFont);
            startPointButton.setBorder(BorderFactory.createLineBorder(col.buttonNormal, 1));
            startPointButton.setFocusable(false);

            add(startPointButton);
            panelTool.buttonHoverSet(startPointButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);

            JButton stopPointButton = new JButton(resources.stopIcon);
            stopPointButton.setVisible(false);
            stopPointButton.setOpaque(true);
            stopPointButton.setBounds(10, 106, 280, 44);
            stopPointButton.setBackground(col.buttonRed);
            stopPointButton.setForeground(col.buttonFont);
            stopPointButton.setBorder(BorderFactory.createLineBorder(col.buttonRed, 1, true));
            stopPointButton.setFocusable(false);
            add(stopPointButton);
            panelTool.buttonHoverSet(stopPointButton, col.buttonRed, col.buttonRedHover, col.buttonDisabled, true);

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
                    bigDigits.setForeground(col.bigDigitsColorYellow);
                    timerCountDown = 1;
                } else if (m == 0 && s == 0 && timerCountDown == 1) {
                    bigDigits.setForeground(col.bigDigitsColorRed);
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
                panelTool.buttonHoverSet(minusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, false);
                panelTool.buttonHoverSet(plusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, false);
                panelTool.buttonHoverSet(nextPointButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, false);
            });

            stopPointButton.addActionListener(e -> {
                stopPointButton.setVisible(false);
                startPointButton.setVisible(true);
                timer.stop();
                panelTool.buttonHoverSet(minusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);
                panelTool.buttonHoverSet(plusMinuteButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);
                panelTool.buttonHoverSet(nextPointButton, col.buttonNormal, col.buttonNormalHover, col.buttonDisabled, true);
                timerCountDown = 0;
                int len = timeToDisplay.length;

                timeToDisplayColumn++;

                if (timeToDisplayColumn < len) {
                    bigDigits.setText(zeroAdd());
                    bigDigits.setForeground(col.bigDigitsColorGreen);
                    TopPanel.tf.setText(String.valueOf(timeToDisplay[timeToDisplayColumn][2]));
                }

                System.out.println(len + " - " + timeToDisplayColumn);
            });

            nextPointButton.addActionListener(e -> {
                int len = timeToDisplay.length;
                timeToDisplayColumn++;

                if (timeToDisplayColumn < len) {

                    bigDigits.setText(zeroAdd());
                    bigDigits.setForeground(col.bigDigitsColorGreen);
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







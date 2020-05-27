package pl.timersk;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TimerFrame extends JFrame {
    private static final long serialVersionUID = 8477335361837551634L;

    public TimerFrame() throws FileNotFoundException, SQLException {
        super("TimerSK");
        final Querys eventsValues = new Querys();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLocation(400, 200);
        this.setSize(500, 500);
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout((LayoutManager)null);
        timerPanel.setBackground(Color.DARK_GRAY);
        this.getContentPane().add(timerPanel);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        final JLabel timerDisplay = new JLabel();
        timerDisplay.setBounds(20, 20, 445, 130);
        timerDisplay.setBorder(border);
        timerDisplay.setOpaque(true);
        timerDisplay.setBackground(Color.WHITE);
        timerDisplay.setText(eventsValues.fromMySql[1][1]);
        timerPanel.add(timerDisplay);
        final JButton startTimerButton = new JButton();
        startTimerButton.setBounds(20, 160, 445, 60);
        startTimerButton.setFont(new Font("Tahoma", 1, 20));
        startTimerButton.setText("START");
        startTimerButton.setVisible(true);
        timerPanel.add(startTimerButton);
        final JButton stopTimerButton = new JButton();
        stopTimerButton.setBounds(20, 160, 445, 60);
        stopTimerButton.setFont(new Font("Tahoma", 1, 20));
        stopTimerButton.setText("STOP");
        stopTimerButton.setVisible(false);
        timerPanel.add(stopTimerButton);
        startTimerButton.addActionListener((e) -> {
            startTimerButton.setVisible(false);
            stopTimerButton.setVisible(true);
            timerDisplay.setText(eventsValues.fromMySql[2][1]);
            String[][] var5 = eventsValues.fromMySql;
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String[] arr = var5[var7];
                System.out.println(Arrays.toString(arr));
            }

        });
        stopTimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimerButton.setVisible(true);
                stopTimerButton.setVisible(false);
                timerDisplay.setText(eventsValues.fromMySql[3][1]);
            }
        });
    }
}

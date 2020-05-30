package pl.timersk;

import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;

public class TimerSK {
    public TimerSK() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new LoginFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //  new XML().createXML();
            try {
                new MainFrame();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }

        });
    }
}

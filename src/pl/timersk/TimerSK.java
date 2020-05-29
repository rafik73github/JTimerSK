package pl.timersk;

import java.awt.EventQueue;
import java.sql.SQLException;

public class TimerSK {
    public TimerSK() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LoginFrame();
          //  new XML().createXML();
            try {
                new MainFrame();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
    }
}

package pl.timersk;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TimerSK {
    public TimerSK() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new LoginFrame();
            new MainFrame();

        });
    }
}

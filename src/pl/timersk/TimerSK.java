package pl.timersk;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class TimerSK {
    public TimerSK() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new LoginFrame();
            } catch (SQLException | NoSuchAlgorithmException | FileNotFoundException var1) {
                var1.printStackTrace();
            }

        });
    }
}

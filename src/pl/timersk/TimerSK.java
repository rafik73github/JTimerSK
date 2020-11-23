package pl.timersk;


import java.awt.*;


public class TimerSK {

   static ParseJSON pj;

    static {
        try {
            pj = new ParseJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public TimerSK() {
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                new TimerFrame();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}

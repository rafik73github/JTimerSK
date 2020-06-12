package pl.timersk;


import java.awt.EventQueue;
import java.io.IOException;
import java.util.Arrays;


public class TimerSK {
   static ParseJSON pj;

    static {
        try {
            pj = new ParseJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public TimerSK() {
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new TimerFrame();
             // System.out.println(Arrays.deepToString(pj.meetingArray()));
           // pj.showJSON();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}

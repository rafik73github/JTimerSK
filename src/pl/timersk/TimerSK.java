package pl.timersk;


import java.awt.*;
import java.util.Map;


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

    public static void main(String[] args)  {


        EventQueue.invokeLater(() -> {
            try {
                printMap();
                new TimerFrame();


            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

   static void printMap() throws Exception {
        Map<Integer, Meetings> mm = new ParseJSON().meetingArray();
        for(int i : mm.keySet()){

            System.out.println("key: " + i + " | title: " + mm.get(i).getPointTitle() + " | time: " + mm.get(i).getPointTime());

        }
    }
}

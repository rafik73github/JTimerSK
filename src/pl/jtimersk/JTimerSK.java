package pl.jtimersk;


import java.awt.*;
import java.io.IOException;


public class JTimerSK {


    public static void main(String[] args) throws IOException {


        if(InternetCheck.isReachable()) {

            EventQueue.invokeLater(() -> {
                try {

                    new FirstFrame();
                    } catch (Exception e) {
                     e.printStackTrace();
                     }
                    });

        }else{
            EventQueue.invokeLater(() -> {
                try {
                    new NoInternetFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });


        }
    }
}

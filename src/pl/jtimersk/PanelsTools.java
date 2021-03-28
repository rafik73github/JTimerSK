package pl.jtimersk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelsTools {

    public void buttonHoverSet(JButton btn, Color normal, Color hover, Color disabled, boolean active){
        btn.setEnabled(active);
        if(active) {
            btn.setBackground(normal);
            btn.setBorder(BorderFactory.createLineBorder(normal, 1));

            btn.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e) {

                    btn.setBackground(hover);
                    btn.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),2));

                }

                public void mouseExited(MouseEvent e) {

                    btn.setBackground(normal);
                    btn.setBorder(BorderFactory.createLineBorder(normal, 1));
                }
            });
        }//rr
        else {
            btn.setBackground(disabled);
            btn.setBorder(BorderFactory.createLineBorder(disabled, 1));

            btn.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e) {

                    btn.setBackground(disabled);
                    btn.setBorder(BorderFactory.createLineBorder(disabled, 1));

                }

                public void mouseExited(MouseEvent e) {

                    btn.setBackground(disabled);
                    btn.setBorder(BorderFactory.createLineBorder(disabled, 1));
                }
            });
        }
    }



}

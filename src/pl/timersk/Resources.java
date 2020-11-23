package pl.timersk;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Resources {


    public static ImageIcon PLAY_ICON = null;

    static {
        try {
            PLAY_ICON = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/play_36x36.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon STOP_ICON = null;

    static {
        try {
            STOP_ICON = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/stop_36x36.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon FORWARD_ICON = null;

    static {
        try {
            FORWARD_ICON = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/forward_36x36.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon PLUS_ICON = null;

    static {
        try {
            PLUS_ICON = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/plus_24x24.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageIcon MINUS_ICON = null;

    static {
        try {
            MINUS_ICON = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/minus_24x24.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage ICON_IMG = null;

    static {
        try {
            ICON_IMG = ImageIO.read(TimerFrame.class.getResourceAsStream("/timersala.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

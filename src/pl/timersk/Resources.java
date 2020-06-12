package pl.timersk;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;


public class Resources {


    final ImageIcon playIcon = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/play_36x36.png")));
    final ImageIcon stopIcon = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/stop_36x36.png")));
    final ImageIcon forwardIcon = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/forward_36x36.png")));
    final ImageIcon plusIcon = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/plus_24x24.png")));
    final ImageIcon minusIcon = new ImageIcon(ImageIO.read(Resources.class.getResourceAsStream("/minus_24x24.png")));

    String connectionURL = new Scanner(Resources.class.getResourceAsStream("/database.txt")).nextLine();

    String meetingJSONURL = new Scanner(Resources.class.getResourceAsStream("/meetingJSONURL.txt")).nextLine();

    public Resources() throws IOException {
    }
}

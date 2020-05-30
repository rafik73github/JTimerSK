package pl.timersk;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    Querys que = new Querys();
    InputStream fileStream = LoginFrame.class.getResourceAsStream("/favicon.png");
    BufferedImage iconImg = ImageIO.read(fileStream);
    //String[] y = que.cNames;
    String[] y = {"LP", "NUMER LEKCJI", "NAZWA LEKCJI"};
    String[][] x = que.aList;
    public MainFrame() throws SQLException, IOException {

        setResizable(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MENU GŁÓWNE");
        setVisible(true);
        setLocation(10,10);
        setSize(500,288);
        setIconImage(iconImg);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //setLayout(null);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setBackground(Color.WHITE);
        cellRenderer.setForeground(Color.RED);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        headerRenderer.setBackground(Color.GRAY);
        headerRenderer.setForeground(Color.WHITE);


        JTable tb = new JTable(x, y);

        tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tb.getColumnModel().getColumn(1).setPreferredWidth(100);
        tb.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tb.getColumnModel().getColumn(1).setHeaderRenderer(headerRenderer);
        tb.getColumnModel().getColumn(2).setPreferredWidth(360);

        tb.removeColumn(tb.getColumnModel().getColumn(0));



        JPanel pan = new JPanel();
        pan.setLayout(null);
        //pan.setLayout(new BoxLayout(pan, BoxLayout.PAGE_AXIS));
       // pan.add(Box.createHorizontalStrut(5));
       // pan.setOpaque(true);
        pan.setBackground(Color.RED);


        JTextField pkt = new JTextField();
       // pkt.setBounds(0,0,100,60);
        pkt.setText("this is a test");
        //pan.add(pkt);

        JScrollPane sc = new JScrollPane(tb);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sc.setVisible(true);
        add(sc);


    }
}

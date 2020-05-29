package pl.timersk;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    Querys que = new Querys();
    String[] y = que.cNames;
    String[][] x = que.aList;
    public MainFrame() throws SQLException {

        setResizable(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MENU GŁÓWNE");
        setVisible(true);
        setLocation(10,10);
        setSize(500,288);
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

        JScrollPane sc = new JScrollPane(tb);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sc.setVisible(true);
        add(sc);



    }
}

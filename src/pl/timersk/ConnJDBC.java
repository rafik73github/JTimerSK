package pl.timersk;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnJDBC {

    String mysqlAuth;
    String connectionURL;
    Connection conn;
    ResultSet rs;

    public ConnJDBC() throws FileNotFoundException {
        Scanner scFile = new Scanner(new File("src\\database.txt"));
       mysqlAuth = scFile.nextLine();
        connectionURL = this.mysqlAuth;
        conn = null;
    }

    public ResultSet connectToDatabase(String query) {
        try {
            this.conn = DriverManager.getConnection(this.connectionURL);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = this.conn.createStatement();
            this.rs = stmt.executeQuery(query);
            return this.rs;
        } catch (ClassNotFoundException var3) {
            System.out.println("Driver problem");
        } catch (SQLException var4) {
            System.out.println("SQLException: " + var4.getMessage());
            System.out.println("SQLState: " + var4.getSQLState());
            System.out.println("VendorError: " + var4.getErrorCode());
        }

        return null;
    }

    public String[][] multi(ResultSet rs) throws SQLException {
        rs.last();
        int lenRs = rs.getRow();
        rs.beforeFirst();
        ResultSetMetaData md = rs.getMetaData();
        int len = md.getColumnCount();
        System.out.println("Columns: " + len + "rows: " + lenRs);
        String[][] dataE = new String[lenRs][len];

        try {
            for(int j = 0; j < lenRs && !rs.isLast(); ++j) {
                rs.next();

                for(int i = 0; i < len; ++i) {
                    dataE[j][i] = rs.getString(rs.getMetaData().getColumnName(i + 1));
                }
            }

            this.conn.close();
        } catch (SQLException var8) {
            var8.printStackTrace();
        }

        return dataE;
    }
}

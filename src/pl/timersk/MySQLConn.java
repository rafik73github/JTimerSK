package pl.timersk;


import java.sql.*;
import java.util.Scanner;
import java.io.InputStream;

public class MySQLConn {

    InputStream fileStream = MySQLConn.class.getResourceAsStream("/database.txt");
    Scanner openFile = new Scanner(fileStream);
    String connAuth = openFile.nextLine();
    String connectionURL = connAuth;

    Connection conn = null;
    ResultSet rs;

    public ResultSet connectToDatabase(String query) {
        try {
            conn = DriverManager.getConnection(connectionURL);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            return rs;
        }
        catch (ClassNotFoundException exception) {
            System.out.println("Driver error");
        } catch (SQLException exception) {
            System.out.println("SQLException: " + exception.getMessage());
            System.out.println("SQLState: " + exception.getSQLState());
            System.out.println("VendorError: " + exception.getErrorCode());
        }
        return null;
    }


    public String[][] getMultiArray(ResultSet rs) throws SQLException {
        String[][] dataE = {};
        rs.last();
        int lenRs = rs.getRow();
        rs.beforeFirst();
        int len = rs.getMetaData().getColumnCount();

        System.out.println("Columns: " + len + ", Rows: " + lenRs);
        if (lenRs != 0) {
            System.out.println(lenRs);
            dataE = new String[lenRs][len];
            try {
                for (int j = 0; j < lenRs; j++) {
                    if (rs.isLast()) {
                        break;
                    }
                    rs.next();
                    for (int i = 0; i < len; i++) {
                        dataE[j][i] = rs.getString((rs.getMetaData().getColumnName(i + 1)));
                    }
                }
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataE;
    }

    public String[] getColumnNames(ResultSet rs) throws SQLException{
        String[] result;
        int len = rs.getMetaData().getColumnCount();
        result = new String[len];
        for (int i = 0; i < len; i++) {
            result[i] = rs.getMetaData().getColumnName(i + 1);
        }

        return result;
    }

    public boolean isInternetConn(String host){
        try{
            String cmd;
            if(System.getProperty("os.name").startsWith("Windows")){
                // for Windows
                cmd = "ping -n 1 " + host;
            }else{
                // for Linux & OSX
                cmd = "ping -c 1 " + host;
            }
            Process myProcess = Runtime.getRuntime().exec(cmd);
            myProcess.waitFor();
            return myProcess.exitValue() == 0;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

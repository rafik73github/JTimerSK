package pl.timersk;

import java.sql.ResultSet;
import java.sql.SQLException;

//TODO I don't now if this class is necessary...

public class Querys {
    public MySQLConn connLM = new MySQLConn();
       String[][] fromMySql;

    public Querys() throws SQLException {

    }
    public ResultSet events = connLM.connectToDatabase("SELECT * FROM tytul_lekcji");
    public String[][] aList = (connLM.getMultiArray(events));
    public String[] cNames = (connLM.getColumnNames(events));
}

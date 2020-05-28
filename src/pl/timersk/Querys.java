package pl.timersk;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO I don't now if this class is necessary...

public class Querys {
    MySQLConn getDataFromMySql = new MySQLConn();
    ResultSet eventsQuery;
    String[][] fromMySql;

    public Querys() throws FileNotFoundException, SQLException {
       // this.eventsQuery = this.getDataFromMySql.connectToDatabase("SELECT * FROM events ORDER BY id_event ASC");
       // this.fromMySql = this.getDataFromMySql.getMultiArray(this.eventsQuery);
    }
}

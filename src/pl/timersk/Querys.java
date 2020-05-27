package pl.timersk;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Querys {
    ConnJDBC getDataFromMySql = new ConnJDBC();
    ResultSet eventsQuery;
    String[][] fromMySql;

    public Querys() throws FileNotFoundException, SQLException {
        this.eventsQuery = this.getDataFromMySql.connectToDatabase("SELECT * FROM events ORDER BY id_event ASC");
        this.fromMySql = this.getDataFromMySql.multi(this.eventsQuery);
    }
}

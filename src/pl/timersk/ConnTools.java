package pl.timersk;

import java.awt.*;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnTools {
    ResultSet connectToDatabase(String query);
    String[][] getMultiArray(ResultSet rs) throws SQLException;
    String[] getColumnNames(ResultSet rs) throws SQLException;
    boolean isInternetConn(String host);
    boolean userValidated(String userLoginFromForm, char[] userPassFromForm) throws NoSuchAlgorithmException, SQLException;
    default void showName(){
        System.out.println("My name is Noname");
    }
}

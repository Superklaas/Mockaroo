package be.vdab.Mockaroo;

import java.sql.SQLException;

public class UserException extends Exception {
    public UserException (SQLException e) {
        System.out.println(e.getMessage() + "\n");
        //System.out.println();
    }
}
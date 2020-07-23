package be.vdab.Mockaroo;

import java.sql.SQLException;

public class PersonException extends Exception {
    public PersonException(SQLException e) {
        System.out.println(e.getMessage() + "\n");
        //System.out.println();
    }
}
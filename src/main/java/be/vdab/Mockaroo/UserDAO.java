package be.vdab.Mockaroo;

import java.sql.*;

public class UserDAO {

    private String url;
    private  String user;
    private String password;

    public UserDAO() {}
    public UserDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }



    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }




}

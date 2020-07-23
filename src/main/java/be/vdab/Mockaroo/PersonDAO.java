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

    public User getUserById(int id) throws UserException {
        String sql = "select * from Users where Id = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user1 = new User();
                    user1.setId(id);
                    user1.setFirstName(rs.getString("first_name"));
                    user1.setLastName(rs.getString("last_name"));
                    user1.setEmail(rs.getString("email"));
                    user1.setGender(rs.getString("gender"));
                    user1.setIpAddress(rs.getString("ip_address"));

                    return beer;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new BeerException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }




}

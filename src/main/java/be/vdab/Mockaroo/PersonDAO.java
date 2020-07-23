package be.vdab.Mockaroo;

import java.sql.*;

public class PersonDAO {

    private String url;
    private  String user;
    private String password;

    public PersonDAO() {}
    public PersonDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Person getPersonById(int id) throws PersonException {
        String sql = "select * from Users where Id = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Person person = new Person();
                    person.setId(id);
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setEmail(rs.getString("email"));
                    person.setGender(rs.getString("gender"));
                    person.setIpAddress(rs.getString("ip_address"));
                    person.setBitcoinId(rs.getInt("bitcoin_id"));
                    return person;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }

    public Person getPersonByLastName(String lastName) throws PersonException {
        String sql = "select * from Users where last_name = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, lastName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(lastName);
                    person.setEmail(rs.getString("email"));
                    person.setGender(rs.getString("gender"));
                    person.setIpAddress(rs.getString("ip_address"));
                    person.setBitcoinId(rs.getInt("bitcoin_id"));
                    return person;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }

    public void createPerson(Person person) throws PersonException {
        String sql = "insert into Users (id, first_name, last_name, email, gender, ip_address) \n" +
                "values ('" +
                person.getId() + "','\n" +
                person.getFirstName() + "','\n" +
                person.getLastName() + "','\n" +
                person.getEmail() + "','\n" +
                person.getGender() + "','\n" +
                person.getIpAddress() + "')";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }




    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

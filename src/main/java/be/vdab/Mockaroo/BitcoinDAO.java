package be.vdab.Mockaroo;

import java.sql.*;

public class BitcoinDAO {

    private String url;
    private  String user;
    private String password;

    public BitcoinDAO() {}
    public BitcoinDAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public double getBalance(String bitcoinAddress) throws PersonException {
        String sql = "select * from Bitcoins where bitcoin_address = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, bitcoinAddress);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Bitcoin bitcoin = new Bitcoin();
                    bitcoin.setId(rs.getInt("id"));
                    bitcoin.setBitcoinAddress(bitcoinAddress);
                    bitcoin.setBalance(rs.getString("amount"));
                    bitcoin.setCreditCardType(rs.getString("credit_card_type"));
                    bitcoin.setCreditCardNumber(rs.getLong("credit_card_number"));
                    return bitcoin.getBalance();
                } else {
                    return 0;
                }
            }
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

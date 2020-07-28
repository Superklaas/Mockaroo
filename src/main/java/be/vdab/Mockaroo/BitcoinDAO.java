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

    public Bitcoin createBitcoinObject(String bitcoinAddress) throws PersonException {
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
                    return bitcoin;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }

    public void updateBitcoin(Bitcoin bitcoin) throws PersonException {
        String sql = "UPDATE Bitcoins SET amount = ? where id = ?";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(2,bitcoin.getId());
            stmt.setString(1,"$" + String.valueOf(bitcoin.getBalance()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new PersonException(ex);
        }
    }

    public double getBalance(String bitcoinAddress) throws PersonException {
        Bitcoin bitcoin = createBitcoinObject(bitcoinAddress);
        return bitcoin.getBalance();
    }

    public void pay(double amount, String bitcoinAddressSender, String bitcoinAddressReceiver) throws PersonException {
        Bitcoin sender = createBitcoinObject(bitcoinAddressSender);
        Bitcoin receiver = createBitcoinObject(bitcoinAddressReceiver);
        if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance()-amount);
            updateBitcoin(sender);
            receiver.setBalance(receiver.getBalance()+amount);
            updateBitcoin(receiver);
        } else {
            System.out.println("Not enough money on account sender");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}

package be.vdab.Mockaroo;

public class Bitcoin {

    private int id;
    private String bitcoinAddress;
    private double balance;
    private String creditCardType;
    private long creditCardNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBitcoinAddress() {
        return bitcoinAddress;
    }

    public void setBitcoinAddress(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalance(String balance) {
        balance = balance.replace('$',' ');
        balance = balance.trim();
        this.balance = Double.parseDouble(balance);
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "id=" + id +
                ", bitcoinAddress='" + bitcoinAddress + '\'' +
                ", amount=" + balance +
                ", creditCardType='" + creditCardType + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                '}';
    }
}

package be.vdab.Mockaroo;

public class Bitcoin {

    int id;
    String bitcoinAddress;
    double balance;
    String creditCardType;
    long creditCardNumber;

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
        // 2 methods to get rid of $ in input string and to parse string to double
        // method 1: replace $ by whitespace and trim (removes whitespace from both ends of a string)
        balance = balance.replace('$',' ');
        balance = balance.trim();
        this.balance = Double.parseDouble(balance);
        // method 2: split at $, doesn't seem to work unfortunately
        /*String[] balanceArray = balance.split("$");
        System.out.println(balanceArray[0]);
        this.balance = Double.parseDouble(balanceArray[0]);*/
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

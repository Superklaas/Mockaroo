package be.vdab.Mockaroo;

public class Bitcoin {

    int id;
    String bitcoinAddress;
    double amount;
    String creditCardType;
    float creditCardNumber;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public float getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(float creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "id=" + id +
                ", bitcoinAddress='" + bitcoinAddress + '\'' +
                ", amount=" + amount +
                ", creditCardType='" + creditCardType + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                '}';
    }
}

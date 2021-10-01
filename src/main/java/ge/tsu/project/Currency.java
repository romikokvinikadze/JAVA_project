package ge.tsu.project;

public class Currency {
    private String code;
    private int quantity;
    private double rate;
    private String name;

    public Currency(String code, int quantity, double rate, String name) {
        this.code = code;
        this.quantity = quantity;
        this.rate = rate;
        this.name = name;
    }

    public Currency(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                ", rate=" + rate +
                ", name='" + name + '\'' +
                '}';
    }
}

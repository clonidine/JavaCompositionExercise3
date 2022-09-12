package entities;

public class OrderItem {

    private String name;
    private Integer quantity;
    private Double price;

    public OrderItem(){};

    public OrderItem(String name, Double price, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double subTotal() {
        return price * quantity;
    }

    public String toString() {
        return name + ", " + "$" + String.format("%.2f", price) + ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}

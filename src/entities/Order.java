package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order(){}

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public String total() {
        double sum = 0.0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getQuantity() * orderItem.getPrice();
        }

        return String.format("$%.2f", sum);
    }
}

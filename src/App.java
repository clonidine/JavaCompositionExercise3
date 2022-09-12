import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        OrderItem orderItem;

        System.out.print("Name: ");
        String clientName = sc.nextLine();

        System.out.print("E-mail: ");
        String clientEmail = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate = simpleDateFormat1.parse(sc.next());
        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("\nEnter order data:");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), orderStatus);
        System.out.print("\nHow many items to this order? ");
        int quantityToOrder = sc.nextInt();

        for (int i = 0; i < quantityToOrder; i++) {
            System.out.printf("\nEnter #%d item data:\n", (i + 1));

            sc.nextLine();

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();

            orderItem = new OrderItem(productName, productPrice, productQuantity);
            order.addItem(orderItem);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println("Order moment: " + simpleDateFormat2.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client);

        System.out.println("\nOrder items:");

        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item);
        }

        System.out.println("Total price: " + order.total());
    }
}

package service;

import helpers.Converter;
import model.Order;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService implements ModelService<Order> {
    @Override
    public ArrayList<Order> getAll() {
        List<String> stringOrders = FileService.readLines("files" + File.separator + "order.txt");
        return Converter.stringToOrders(stringOrders);
    }

    @Override
    public Order getByID(String ID) {
        for (Order order :
                getAll()) {
            if (order.getID().equals(ID)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void print(Order object) {
        System.out.println("ID: " + object.getID());
        System.out.println("Product: " + (new ProductService().getByID(object.getProductID())).getName());
        System.out.println("Buyer: " + new UserService().getByID(object.getBuyerID()).getName());
        System.out.println("Quantity: " + object.getQuantity());
        System.out.println("Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(object.getDate()));
    }

    @Override
    public void printAll(ArrayList<Order> objects) {
        for (Order object :
                objects) {
            System.out.println("-----------------------");
            print(object);
            System.out.println("-----------------------");
        }
    }

    public Order create(String productID, String buyerID, int quantity) {
        Order newOrder = new Order(UUID.randomUUID().toString(), productID, buyerID, quantity);
        FileService.append("files" + File.separator + "order.txt", newOrder.toString());
        return newOrder;
    }

    public ArrayList<Order> getOrdersByBuyerID(String BuyerID) {
        ArrayList<Order> allOrders = getAll();
        ArrayList<Order> buyersOrder = new ArrayList<>();
        for (Order order :
                allOrders) {
            if (order.getBuyerID().equals(BuyerID)) buyersOrder.add(order);
        }
        return buyersOrder;
    }

}

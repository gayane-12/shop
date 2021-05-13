package helpers;

import model.Order;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static User stringToUser(String string) {
        String[] splittedPerProperty = string.split(",");
        return new User(splittedPerProperty[0], splittedPerProperty[1],
                splittedPerProperty[2], splittedPerProperty[3], splittedPerProperty[4], splittedPerProperty[5]);
    }

    public static ArrayList<User> stringToUsers(List<String> stringUsers) {
        ArrayList<User> users = new ArrayList<>();
        if (stringUsers != null) {
            for (String stringUser :
                    stringUsers) {
                users.add(Converter.stringToUser(stringUser));
            }
        }
        return users;
    }

    public static Product stringToProduct(String string) {
        String[] splittedPerProperty = string.split(",");
        return new Product(splittedPerProperty[0], splittedPerProperty[1],
                splittedPerProperty[2], Integer.parseInt(splittedPerProperty[3]), Double.parseDouble(splittedPerProperty[4]), splittedPerProperty[5]);
    }

    public static ArrayList<Product> stringToProducts(List<String> stringProducts) {
        ArrayList<Product> products = new ArrayList<>();
        if (stringProducts != null) {
            for (String stringProduct :
                    stringProducts) {
                products.add(Converter.stringToProduct(stringProduct));
            }
        }
        return products;
    }

    public static Order stringToOrder(String string) {
        String[] splittedPerProperty = string.split(",");
        return new Order(splittedPerProperty[0], splittedPerProperty[1],
                splittedPerProperty[2], Integer.parseInt(splittedPerProperty[3]));
    }

    public static ArrayList<Order> stringToOrders(List<String> stringOrders) {
        ArrayList<Order> orders = new ArrayList<>();
        if (stringOrders != null) {
            for (String stringOrder :
                    stringOrders) {
                orders.add(Converter.stringToOrder(stringOrder));
            }
        }
        return orders;
    }

}

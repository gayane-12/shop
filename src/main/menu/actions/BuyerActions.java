package main.menu.actions;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import main.menu.ProfileMenu;
import model.Order;
import model.Product;
import model.User;

import java.util.ArrayList;


public class BuyerActions extends Actions {

    public void actions(User user) throws BadRequestException {
        System.out.println("================================");
        System.out.println("|         BUYER ACTIONS        |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|        1. Buy product        |");
        System.out.println("|        2. All products       |");
        System.out.println("|        3. My orders          |");
        System.out.println("|        0. Back               |");
        System.out.println("================================");

        int choice = INPUT.nextInt();
        switch (choice) {
            case 1:
                buyProduct(user);
                break;
            case 2:
                allProducts();
                actions(user);
                break;
            case 3:
                seeMyOrders(user);
                actions(user);
                break;
            case 0:
                ProfileMenu.profile(user);
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
    }

    private void buyProduct(User user) throws BadRequestException {
        System.out.println("Enter product ID:");
        String ID = INPUT.next();
        System.out.println("Enter quantity:");
        int count = INPUT.nextInt();
        orderService.create(ID, user.getID(), count);
        productService.editProductByID(ID, "quantity", String.valueOf(productService.getByID(ID).getCount() - count));
        seeMyOrders(user);
    }

    private void seeMyOrders(User user) throws BadRequestException {
        ArrayList<Order> ordersByBuyerID = orderService.getOrdersByBuyerID(user.getID());
        orderService.printAll(ordersByBuyerID);
        System.out.println("| TOTAL COUNT OF ORDERS     " + ordersByBuyerID.size() + " |");
        actions(user);
    }

}

package main.menu.actions;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import model.Product;
import model.User;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Actions {
    protected static Scanner INPUT = new Scanner(System.in).useDelimiter("\n");
    protected static ProductService productService = new ProductService();
    protected static UserService userService = new UserService();
    protected static OrderService orderService = new OrderService();
    protected User user;

    protected abstract void actions(User user) throws NotFoundException, BadRequestException;

    protected static void sortActions(){
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|    1. Ascending order        |");
        System.out.println("|    2. Descending order       |");
        System.out.println("|    0. Back                   |");
        System.out.println("================================");
    }

    protected static void allProducts(){
        System.out.println("================================");
        System.out.println("|         ALL PRODUCTS         |");
        System.out.println("================================");
        ArrayList<Product> products = productService.getAll();
        productService.printAll(products);
    }


}

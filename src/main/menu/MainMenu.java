package main.menu;

import exceptions.BadRequestException;
import exceptions.NotFoundException;

import java.util.Scanner;

public class MainMenu {

    public static void welcome() throws  BadRequestException {
        System.out.println("================================");
        System.out.println("|     WELCOME TO OUR SHOP      |");
        System.out.println("================================");
        try {
            home();
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
            home();
        }
    }

    static void home() throws  BadRequestException {
        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("|             HOME             |");
        System.out.println("|         Who are you ?        |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|          1. Seller           |");
        System.out.println("|          2. Buyer            |");
        System.out.println("|          3. Admin            |");
        System.out.println("================================");

        int choice = input.nextInt();
        String personRole = "";

        switch (choice) {
            case 0:
                home();
                break;
            case 1:
                personRole = "seller";
                break;
            case 2:
                personRole = "buyer";
                break;
            case 3:
                personRole = "admin";
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
        try {
            AuthMenu.isRegistered(personRole);
        } catch (BadRequestException e) {
            System.out.println(e.getMessage());
            AuthMenu.isRegistered(personRole);
        }
    }

}

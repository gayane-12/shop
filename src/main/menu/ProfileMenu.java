package main.menu;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import main.menu.actions.AdminActions;
import main.menu.actions.BuyerActions;
import main.menu.actions.SellerActions;
import model.User;

import java.util.Scanner;

public class ProfileMenu {
    private static Scanner INPUT = new Scanner(System.in);

    public static void profile(User user) throws BadRequestException {
        System.out.println("================================");
        System.out.println("|            PROFILE           |");
        System.out.println("================================");
        System.out.println("| Your information:            |");
        System.out.println("================================");
        System.out.println("Full name:" + user.getName() + " " + user.getSurname());
        System.out.println("Email:" + user.getEmail());
        System.out.println("User type:" + user.getType());
        System.out.println("================================");
        System.out.println("| 1. Actions                   |");
        System.out.println("================================");
        System.out.println("| 0. Logout                    |");
        System.out.println("================================");
        int choice = INPUT.nextInt();
        switch (choice) {
            case 1:
                actions(user);
                break;
            case 0:
                logout();
                break;
            default:
                throw new BadRequestException("Unknown option");
        }

    }

    private static void logout() throws BadRequestException {
        MainMenu.home();
    }

    public static void actions(User user) throws BadRequestException {
        switch (user.getType()) {
            case "seller":
                new SellerActions().actions(user);
                break;
            case "buyer":
                new BuyerActions().actions(user);
                break;
            case "admin":
                new AdminActions().actions(user);
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
    }

}

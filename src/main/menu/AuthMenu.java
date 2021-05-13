package main.menu;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import model.User;
import service.AuthService;

import java.util.Scanner;


public class AuthMenu {
    private static Scanner INPUT = new Scanner(System.in);

    static void isRegistered(String personRole) throws BadRequestException {
        System.out.println("================================");
        System.out.println("|      Are you registered ?    |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|            1. Yes            |");
        System.out.println("|            2. No             |");
        System.out.println("|            0. Back           |");
        System.out.println("================================");

        int choice = INPUT.nextInt();
        switch (choice) {
            case 1:
                AuthMenu.login();
                break;
            case 2:
                AuthMenu.register(personRole);
                break;
            case 0:
                MainMenu.home();
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
    }

    private static void login() {
        System.out.println("================================");
        System.out.println("|             LOGIN            |");
        System.out.println("================================");
        System.out.println("|       Enter your email       |");
        String email = INPUT.next();
        System.out.println("|      Enter your password     |");
        String password = INPUT.next();
        try {
            User loggedUser = AuthService.login(email, password);
            ProfileMenu.profile(loggedUser);
        } catch (BadRequestException | NotFoundException e) {
            System.out.println(e.getMessage());
            AuthMenu.login();
        }
    }

    private static void register(String personRole) {
        System.out.println("================================");
        System.out.println("|           REGISTER           |");
        System.out.println("================================");
        System.out.println("| Enter  your name:            |");
        String name = INPUT.next();
        System.out.println("| Enter  your surname:         |");
        String surname = INPUT.next();
        System.out.println("| Enter  your email:           |");
        String email = INPUT.next();
        System.out.println("| Enter  your password:        |");
        String password = INPUT.next();

        AuthService.register(name, surname, email, password, personRole);
        AuthMenu.login();
    }

}

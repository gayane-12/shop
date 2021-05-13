package main.menu.actions;

import exceptions.BadRequestException;
import main.menu.ProfileMenu;
import model.User;

import java.util.ArrayList;

public  class AdminActions extends Actions {

    public void actions(User user) throws BadRequestException {
        System.out.println("================================");
        System.out.println("|         ADMIN ACTIONS        |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|        1. All users          |");
        System.out.println("|        2. All products       |");
        System.out.println("|        0. Back               |");
        System.out.println("================================");

        int choice = INPUT.nextInt();
        switch (choice) {
            case 1:
                seeUsers();
                break;
            case 2:
                allProducts();
                actions(user);
                break;
            case 0:
                ProfileMenu.actions(user);
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
    }

    private void seeUsers() throws BadRequestException {
        ArrayList<User> users = userService.getAll();
        userService.printAll(users);
        System.out.println("| TOTAL COUNT OF USERS     " + users.size() + " |");
        actions(user);
    }
}

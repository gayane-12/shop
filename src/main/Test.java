package main;


import exceptions.BadRequestException;
import exceptions.NotFoundException;
import main.menu.MainMenu;

public class Test {
    public static void main(String[] args) throws NotFoundException, BadRequestException {
        MainMenu.welcome();
    }
}

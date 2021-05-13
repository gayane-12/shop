package service;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import model.User;


public class AuthService {
    private static UserService userService = new UserService();

    public static void register(String name, String surname, String email, String password, String type) {
        userService.create(name, surname, email, password, type);
    }

    public static User login(String email, String password) throws BadRequestException, NotFoundException {
        User existingUser = userService.getByEmail(email);
        if (existingUser != null) {
            if (userService.isPasswordCorrect(password, existingUser.getPassword())) {
                return existingUser;
            } else throw new BadRequestException("Wrong password.");
        } else {
            throw new NotFoundException("User not found.");
        }
    }

}

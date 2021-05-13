package service;

import helpers.Converter;
import model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService implements ModelService<User> {

    @Override
    public ArrayList<User> getAll() {
        List<String> stringUsers = FileService.readLines("files" + File.separator + "users.txt");
        return Converter.stringToUsers(stringUsers);
    }

    @Override
    public User getByID(String ID) {
        for (User user :
                getAll()) {
            if (user.getID().equals(ID)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void print(User object) {
        System.out.println("ID: " + object.getID());
        System.out.println("Name: " + object.getName());
        System.out.println("Surname: " + object.getSurname());
        System.out.println("Email: " + object.getEmail());
        System.out.println("Password: " + object.getPassword());
        System.out.println("Type: " + object.getType());
    }

    @Override
    public void printAll(ArrayList<User> objects) {
        for (User object :
                objects) {
            System.out.println("-----------------------");
            print(object);
            System.out.println("-----------------------");
        }
    }

    public User create(String name, String surname, String email, String password, String type) {
        User newUser = new User(UUID.randomUUID().toString(), name, surname, email, password, type);
        FileService.append("files" + File.separator + "users.txt", newUser.toString());
        return newUser;
    }

    public User getByEmail(String email) {
        for (User user :
                getAll()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public boolean isPasswordCorrect(String password, String userPassword) {
        return userPassword.equals(password);
    }

}

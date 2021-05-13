package main.menu.actions;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import main.menu.ProfileMenu;
import model.Product;
import model.User;

import java.util.ArrayList;

public class SellerActions extends Actions {

    public void actions(User user) throws  BadRequestException {
        System.out.println("================================");
        System.out.println("|        SELLER ACTIONS        |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:  |");
        System.out.println("|        1. Add product        |");
        System.out.println("|        2. My products        |");
        System.out.println("|        3. All products        |");
        System.out.println("|        0. Back               |");
        System.out.println("================================");

        int choice = INPUT.nextInt();
        switch (choice) {
            case 1:
                addProduct(user);
                break;
            case 2:
                seeMyProducts(user);
                break;
            case 3:
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

    private void addProduct(User user) throws BadRequestException {
        System.out.println("================================");
        System.out.println("|          ADD PRODUCT         |");
        System.out.println("================================");
        System.out.println("| Enter product name:          |");
        String name = INPUT.next();
        System.out.println("| Enter product quantity:      |");
        int quantity = INPUT.nextInt();
        System.out.println("| Enter product price:         |");
        double price = INPUT.nextDouble();
        System.out.println("| Enter product description:   |");
        String description = INPUT.next();

        productService.create(name, description, quantity, price, user);

        System.out.println("Product was successfully created.");
        actions(user);
    }

    private void seeMyProducts(User user) throws BadRequestException {
        ArrayList<Product> productsBySellerID = productService.getProductsBySellerID(user.getID());
        productService.printAll(productsBySellerID);
        System.out.println("| TOTAL COUNT OF PRODUCTS     " + productsBySellerID.size() + " |");
        productActions(user);
    }

    private void productActions(User user) throws  BadRequestException {
        System.out.println("================================");
        System.out.println("|        PRODUCT ACTIONS        |");
        System.out.println("================================");
        System.out.println("| Enter the number of option:   |");
        System.out.println("| 1. Sort by Price              |");
        System.out.println("| 2. Out of stock products      |");
        System.out.println("| 3. Delete product             |");
        System.out.println("| 4. Edit product               |");
        System.out.println("| 0. Back to actions            |");
        System.out.println("================================");

        int choice = INPUT.nextInt();

        switch (choice) {
            case 0:
                actions(user);
                break;
            case 1:
                sortActions(user);
                break;
            case 2:
                ArrayList<Product> sellersOutOfStockProducts = productService.getSellersOutOfStockProducts(user.getID());
                productService.printAll(sellersOutOfStockProducts);
                productActions(user);
                break;
            case 3:
                deleteProduct(user);
                break;
            case 4:
                editProduct(user);
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
    }

    private void sortActions(User user) throws BadRequestException {
        sortActions();
        int choice = INPUT.nextInt();
        ArrayList<Product> products = new ArrayList<>();
        switch (choice) {
            case 0:
                productActions(user);
                break;
            case 1:
                products = productService.sortProductsByPrice(true, productService.getProductsBySellerID(user.getID()));
                break;
            case 2:
                products = productService.sortProductsByPrice(false, productService.getProductsBySellerID(user.getID()));
                break;
            default:
                throw new BadRequestException("Unknown option");
        }
        productService.printAll(products);
        productActions(user);
    }


    private void deleteProduct(User user) throws BadRequestException {
        System.out.println("Enter product ID:");
        String ID = INPUT.next();
        productService.updateProducts(productService.deleteProductByID(ID));
        System.out.println("Product has been deleted.");
        productActions(user);
    }

    private void editProduct(User user) throws BadRequestException {
        System.out.println("Enter product ID:");
        String ID = INPUT.next();
        System.out.println("=================================================");
        System.out.println("| Enter the number of option you want to edit:  |");
        System.out.println("|    1. Product name                            |");
        System.out.println("|    2. Product quantity                        |");
        System.out.println("|    3. Product price                           |");
        System.out.println("|    4. Product description                     |");
        System.out.println("|    0. Back                                    |");
        System.out.println("=================================================");

        int choice = INPUT.nextInt();
        String editableProperty = "";
        switch (choice) {
            case 0:
                productActions(user);
                break;
            case 1:
                editableProperty = "name";
                break;
            case 2:
                editableProperty = "count";
                break;
            case 3:
                editableProperty = "price";
                break;
            case 4:
                editableProperty = "description";
                break;
            default:
                throw new BadRequestException("Unknown option: " + choice);
        }

        System.out.println("Enter the new value:");
        String editingValue = INPUT.next();
        productService.editProductByID(ID, editableProperty, editingValue);
        System.out.println("Product data has been updated.");
        productActions(user);
    }


}

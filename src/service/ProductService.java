package service;

import exceptions.BadRequestException;
import exceptions.NotFoundException;
import helpers.Converter;
import model.Product;
import model.User;

import java.io.File;
import java.util.*;

public class ProductService implements ModelService<Product> {

    @Override
    public ArrayList<Product> getAll() {
        List<String> stringProducts = FileService.readLines("files" + File.separator + "products.txt");
        return Converter.stringToProducts(stringProducts);
    }

    @Override
    public Product getByID(String ID) {
        ArrayList<Product> allProducts = getAll();
        for (Product product :
                allProducts) {
            if (product.getID().equals(ID)) return product;
        }
        return null;
    }

    @Override
    public void print(Product object) {
        System.out.println("ID: " + object.getID());
        System.out.println("Name: " + object.getName());
        System.out.println("Description: " + object.getDescription());
        System.out.println("In Stock: " + object.getCount());
        System.out.println("Price: " + object.getPrice() + "$");
        System.out.println("Seller: " + new UserService().getByID(object.getSellerID()).getName());
    }

    @Override
    public void printAll(ArrayList<Product> objects) {
        for (Product product :
                objects) {
            System.out.println("-----------------------");
            print(product);
            System.out.println("-----------------------");

        }
    }

    public Product create(String name, String description, int count, double price, User seller) {
        Product newProduct = new Product(UUID.randomUUID().toString(), name, description, count, price, seller.getID());
        FileService.append("files" + File.separator + "products.txt", newProduct.toString());
        return newProduct;
    }


    public ArrayList<Product> getProductsBySellerID(String SellerID) {
        ArrayList<Product> allProducts = getAll();
        ArrayList<Product> sellersProduct = new ArrayList<>();
        for (Product product :
                allProducts) {
            if (product.getSellerID().equals(SellerID)) sellersProduct.add(product);
        }
        return sellersProduct;
    }


    public ArrayList<Product> sortProductsByPrice(boolean asc, ArrayList<Product> products) {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return asc ? (int) (o1.getPrice() - o2.getPrice()) : (int) (o2.getPrice() - o1.getPrice());
            }
        });
        return products;
    }

    public ArrayList<Product> getSellersOutOfStockProducts(String sellerID) {
        ArrayList<Product> sellersProducts = getProductsBySellerID(sellerID);
        ArrayList<Product> outOfStocks = new ArrayList<>();
        for (Product product :
                sellersProducts) {
            if (product.getCount() == 0) outOfStocks.add(product);
        }
        return outOfStocks;
    }

    public ArrayList<Product> deleteProductByID(String productID) {
        ArrayList<Product> allProducts = getAll();
        Iterator<Product> it = allProducts.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getID().equals(productID)) {
                it.remove();
            }
        }
        return allProducts;

    }

    public void updateProducts(ArrayList<Product> products) {
        FileService.empty("files" + File.separator + "products.txt");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null)
                FileService.append("files" + File.separator + "products.txt", products.get(i).toString());
        }
    }

    public void editProductByID(String ID, String property, String value) throws BadRequestException {
        ArrayList<Product> allProducts = getAll();

        for (Product product :
                allProducts) {
            if (product.getID().equals(ID)) {
                switch (property) {
                    case "name":
                        product.setName(value);
                        break;
                    case "price":
                        product.setPrice(Double.parseDouble(value));
                        break;
                    case "quantity":
                        product.setCount(Integer.parseInt(value));
                        break;
                    case "description":
                        product.setDescription(value);
                        break;
                    default:
                        throw new BadRequestException("Unknown option");
                }
            }
        }
        updateProducts(allProducts);
    }


}


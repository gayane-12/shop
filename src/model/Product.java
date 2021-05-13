package model;

public class Product {
    private String ID;
    private String name;
    private String description;
    private int count;
    private double price;
    private String SellerID;

    public Product(String ID, String name, String description, int count, double price, String sellerID) {
        this.setID(ID);
        this.setName(name);
        this.setDescription(description);
        this.setCount(count);
        this.setPrice(price);
        this.setSellerID(sellerID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSellerID() {
        return SellerID;
    }

    public void setSellerID(String sellerID) {
        SellerID = sellerID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.getID() + ","
                + this.getName() + ","
                + this.getDescription() + ","
                + this.getCount() + ","
                + this.getPrice() + ","
                + this.getSellerID() + ",";
    }


}
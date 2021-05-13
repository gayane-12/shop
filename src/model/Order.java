package model;

import java.util.Date;

public class Order {
    private String ID;
    private String productID;
    private String buyerID;
    private int quantity;
    private Date date;

    public Order(String ID, String productID, String buyerID, int quantity) {
        this.setID(ID);
        this.setBuyerID(buyerID);
        this.setProductID(productID);
        this.setQuantity(quantity);
        this.setDate(new Date());
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(String buyerID) {
        this.buyerID = buyerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                + this.getProductID() + ","
                + this.getBuyerID() + ","
                + this.getQuantity() + ","
                + this.getDate() + ",";
    }
}

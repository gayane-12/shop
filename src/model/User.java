package model;

public  class User {
    protected String ID;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected String type;

    public User(String ID, String name, String surname, String email, String password, String type) {
        this.setID(ID);
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
    }

    public User() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getID() + ","
                + this.getName() + ","
                + this.getSurname() + ","
                + this.getEmail() + ","
                + this.getPassword() + ","
                + this.getType() + ",";
    }

}

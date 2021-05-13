package service;

import java.util.ArrayList;

public interface ModelService<T> {

    ArrayList<T> getAll();

    T getByID(String ID);

    void print(T object);

    void printAll(ArrayList<T> objects);

}

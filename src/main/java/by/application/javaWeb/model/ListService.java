package by.application.javaWeb.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private static List<Product> groupList = new ArrayList();

    static public List<Product> retrieveList() {
        return groupList;
    }


    static public void addPerson(Product product) {
        groupList.add(new Product(product));
    }
}

package by.application.javaWeb.model.person;

import by.application.javaWeb.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private static List<Product> groupList = new ArrayList();

    static {
     //   groupList.add(new Product("galaxy s21 ultra", "350$", "Samsung", "2022"));
    }

    static public List<Product> retrieveList() {
        System.out.println(groupList);
        return groupList;
    }

    static public void addProduct(Product product) {
        groupList.add(new Product(product));
    }
}

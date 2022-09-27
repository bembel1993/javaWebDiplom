package by.application.javaWeb.service;

import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> showProduct();
    Product findProductByName(String nameprod);
}

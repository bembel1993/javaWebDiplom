package by.application.javaWeb.dao;

import by.application.javaWeb.model.product.Product;

import java.util.List;

public interface ProductDao {
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> showProduct();
    Product findProductById(int id);
    Product findProductName(String nameprod);
}

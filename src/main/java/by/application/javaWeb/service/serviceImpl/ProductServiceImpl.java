package by.application.javaWeb.service.serviceImpl;

import by.application.javaWeb.dao.ProductDao;
import by.application.javaWeb.dao.daoImpl.ProductDaoImpl;
import by.application.javaWeb.model.Product;
import by.application.javaWeb.service.ProductService;
import org.hibernate.HibernateError;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    public ProductServiceImpl(){}

    @Override
    public boolean addProduct(Product product) {
        boolean isAdded = false;
        try {
            if (productDao.addProduct(product))
                isAdded = true;
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public List<Product> showProduct() {
        List<Product> products = null;
        try {
            products = productDao.showProduct();
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return products;
    }

    @Override
    public Product findProductByName(String nameprod) {
        Product product = null;
        try {
            product = productDao.findProductByName(nameprod);
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return product;
    }
}

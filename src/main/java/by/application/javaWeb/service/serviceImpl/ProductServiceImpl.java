package by.application.javaWeb.service.serviceImpl;

import by.application.javaWeb.dao.ProductDao;
import by.application.javaWeb.dao.daoImpl.ProductDaoImpl;
import by.application.javaWeb.model.product.Product;
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
    public boolean updateProduct(Product product) {
        boolean isUpdated = false;
        try {
            if (productDao.updateProduct(product))
                isUpdated = true;
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean isDeleted = false;
        try {
            if (productDao.deleteProduct(id)){
                System.out.println("Session success - delete");
                isDeleted = true;
            }
        }
        catch (HibernateError e) {
            //  ShowException.showNotice(e);
        }
        return isDeleted;
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
    public Product findProductById(int id) {
        Product product = null;
        try {
            product = productDao.findProductById(id);
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return product;
    }

    @Override
    public Product findProductName(String nameprod) {
        Product product = null;
        try {
            product = productDao.findProductName(nameprod);
        }
        catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return product;
    }
}

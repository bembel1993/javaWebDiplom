package by.application.javaWeb.dao.daoImpl;

import by.application.javaWeb.dao.ProductDao;
import by.application.javaWeb.model.product.Product;
import by.application.javaWeb.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public boolean addProduct(Product product) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            session.close();
            isAdded = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(product);
            tx.commit();
            session.close();
            System.out.println("Session success - Update");
            isUpdated = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Product product = session.load(Product.class, id);
            Transaction tx = session.beginTransaction();
            session.delete(product);
            tx.commit();
            session.close();
            System.out.println("Session success - delete");
            isDeleted = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }

    @Override
    public List<Product> showProduct() {
        List<Product> products = (List<Product>)SessionFactoryImpl.getSessionFactory().
                openSession().createQuery("FROM Product").list();
        return products;
    }

    @Override
    public Product findProductById(int id) {
        Product product = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cr = cb.createQuery(Product.class);
            Root<Product> root = cr.from(Product.class);
            cr.select(root).where(cb.equal(root.get("id"), id));
            product = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return product;
    }
    @Override
    public Product findProductName(String nameprod) {
        Product product = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cr = cb.createQuery(Product.class);
            Root<Product> root = cr.from(Product.class);
            cr.select(root).where(cb.equal(root.get("nameprod"), nameprod));
            product = session.createQuery(cr).getSingleResult();
            tx.commit();
            session.close();
            System.out.println("find by name - success");
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return product;
    }
}

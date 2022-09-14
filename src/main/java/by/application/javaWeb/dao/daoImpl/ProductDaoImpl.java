package by.application.javaWeb.dao.daoImpl;

import by.application.javaWeb.dao.PersonDao;
import by.application.javaWeb.dao.ProductDao;
import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;
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
    public List<Product> showProduct() {
        List<Product> products = (List<Product>)SessionFactoryImpl.getSessionFactory().
                openSession().createQuery("FROM Product").list();
        return products;
    }

    @Override
    public Product findProductByName(String nameprod) {
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
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return product;
    }
}

package by.application.javaWeb.dao.daoImpl;

import by.application.javaWeb.dao.MessageDao;
import by.application.javaWeb.model.message.Message;
import by.application.javaWeb.model.product.Product;
import by.application.javaWeb.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public boolean addMessage(Message message) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(message);
            tx.commit();
            session.close();
            System.out.println("Session success - add");
            isAdded = true;
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public List<Message> showMessage() {
        List<Message> messages = (List<Message>) SessionFactoryImpl.getSessionFactory().
                openSession().createQuery("FROM Message order by id desc").list();
        return messages;
    }
}

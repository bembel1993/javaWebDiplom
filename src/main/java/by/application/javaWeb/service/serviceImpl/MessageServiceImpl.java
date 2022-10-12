package by.application.javaWeb.service.serviceImpl;

import by.application.javaWeb.dao.MessageDao;
import by.application.javaWeb.dao.ProductDao;
import by.application.javaWeb.dao.daoImpl.MessageDaoImpl;
import by.application.javaWeb.dao.daoImpl.ProductDaoImpl;
import by.application.javaWeb.model.message.Message;
import by.application.javaWeb.model.product.Product;
import by.application.javaWeb.service.MessageService;
import org.hibernate.HibernateError;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    MessageDao messageDao = new MessageDaoImpl();

    public MessageServiceImpl() {
    }

    @Override
    public boolean addMessage(Message message) {
        boolean isAdded = false;
        try {
            if (messageDao.addMessage(message))
                isAdded = true;
        } catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public List<Message> showMessage() {
        List<Message> messages = null;
        try {
            messages = messageDao.showMessage();
        } catch (HibernateError e) {
            // ShowException.showNotice(e);
        }
        return messages;
    }
}

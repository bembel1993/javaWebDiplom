package by.application.javaWeb.dao;

import by.application.javaWeb.model.message.Message;
import by.application.javaWeb.model.product.Product;

import java.util.List;

public interface MessageDao {
    boolean addMessage(Message message);
    List<Message> showMessage();
}

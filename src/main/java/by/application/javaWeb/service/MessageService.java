package by.application.javaWeb.service;

import by.application.javaWeb.model.message.Message;
import by.application.javaWeb.model.product.Product;

import java.util.List;

public interface MessageService {
    boolean addMessage(Message message);
    List<Message> showMessage();
}

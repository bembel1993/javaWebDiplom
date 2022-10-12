package by.application.javaWeb.model.message;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    private static List<Message> groupList = new ArrayList();

    static public List<Message> retrieveList() {
        System.out.println(groupList);
        return groupList;
    }

    static public void addMessage(Message message) {
        groupList.add(new Message(message));
    }
}

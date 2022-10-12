package by.application.javaWeb.model;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "person")
    private String person;
    @Column(name = "message")
    private String message;

    public Message() {
    }

    public Message(int id, String person, String message) {
        this.id = id;
        this.person = person;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
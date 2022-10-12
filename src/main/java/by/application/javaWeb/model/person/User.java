package by.application.javaWeb.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @Column
    private String login;
    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;

    public User(){
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginUser() {
        return login;
    }

    public void setLoginUser(String login) {
        this.login = login;
    }

    public String getPasswordUser() {
        return password;
    }

    public void setPasswordUser(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

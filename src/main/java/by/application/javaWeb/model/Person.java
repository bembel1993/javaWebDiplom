package by.application.javaWeb.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "date")
    private String date;
    @Column (name = "email")
    private String email;
    @Column (name = "number")
    private String number;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;
    //------------for User bind----------------
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addUser(User newUser) {
        newUser.setPerson(this);
        user = newUser;
    }

    public Person() {
    }

    public Person(String name, String surname, String date, String email, String number) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.email = email;
        this.number = number;
        user = new User();
    }

    public Person(Person person) {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return date;
    }

    public void setDateOfBirth(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return number;
    }

    public void setNumberPhone(String number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id" + id + '\'' +
                "firstName='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + date + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + number + '\'' +
                '}';
    }
}

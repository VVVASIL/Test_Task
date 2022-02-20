package by.orlov.test.task.Test_Task.Entity;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_main;
    @Column(name = "id_symbol")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "price")
    private Double priceWhenRegistration;
    @Column(name = "changeP")
    public boolean changePrice = false;

    public Person(int id, String login, Double priceWhenRegistration) {
        this.id = id;
        this.login = login;
        this.priceWhenRegistration = priceWhenRegistration;
    }
    public Person() {
    }
    public int getId_main() {
        return id_main;
    }
    public void setId_main(int id_main) {
        this.id_main = id_main;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public Double getPriceWhenRegistration() {
        return priceWhenRegistration;
    }
    public void setPriceWhenRegistration(Double priceWhenRegistration) {
        this.priceWhenRegistration = priceWhenRegistration;
    }
    public boolean isChangePrice() {
        return changePrice;
    }
    public void setChangePrice(boolean changePrice) {
        this.changePrice = changePrice;
    }

    @Override
    public String toString() {
        return "Пользователь зарегистрировался и выбрал монету под " +
                "id = " + id +
                ", имя пользователя: " + login;
    }
}

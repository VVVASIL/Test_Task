package by.orlov.test.task.Test_Task.entity;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_main;
    @Column(name = "id_symbol")
    private int id;
    @Column(name = "price_usd")
    private Double price_usd;

    public int getId_main() {
        return id_main;
    }
    public void setId_main(int id) {
        this.id_main = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int symbolId) {
        this.id = symbolId;
    }
    public Double getPrice_usd() {
        return price_usd;
    }
    public void setPrice_usd(Double price_usd) {
        this.price_usd = price_usd;
    }
    public Price(int id, Double price_usd) {
        this.id = id;
        this.price_usd = price_usd;
    }
    public Price() {
    }
}

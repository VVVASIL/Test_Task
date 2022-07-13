package by.orlov.test.task.Test_Task.entity;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class CoinsAll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "id_symbol")
    private int symbolId;
    @Column(name = "symbol")
    private String symbol;

    public CoinsAll() {
    }
    public CoinsAll(int symbolId, String symbol) {
        this.symbolId = symbolId;
        this.symbol = symbol;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSymbolId() {
        return symbolId;
    }
    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

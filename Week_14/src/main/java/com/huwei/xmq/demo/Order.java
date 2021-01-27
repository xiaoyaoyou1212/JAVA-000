package com.huwei.xmq.demo;

public class Order {
    private Long id;
    private Long ts;
    private String symbol;
    private Double price;

    public Order(Long id, Long ts, String symbol, Double price) {
        this.id = id;
        this.ts = ts;
        this.symbol = symbol;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ts=" + ts +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}

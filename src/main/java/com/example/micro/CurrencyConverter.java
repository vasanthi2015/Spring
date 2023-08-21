package com.example.micro;


import java.math.BigDecimal;

public class CurrencyConverter {


    private Long id;

    private String from;

    private String to;

    private Integer quantity;

    private BigDecimal conversionMultiple;

    private BigDecimal amount;
    public CurrencyConverter() {

    }

    public CurrencyConverter(long id, String from, String to, Integer quantity, BigDecimal conversionMultiple, BigDecimal amount){
        this.id = id;
        this.from= from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
package com.example.MenuSpring.dto;

import java.time.LocalDate;

public class DishDTO {
    private String name;
    private Double price;
    private String type;
    private LocalDate date;

    public DishDTO(String name, Double price, String type, LocalDate date) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.date= date;
    }

    public DishDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

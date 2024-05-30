package com.example.MenuSpring.dto;

import java.time.LocalDate;

public class MenuDTO {
    Double price;
    LocalDate date;

    public MenuDTO(Double price, LocalDate date) {
        this.price = price;
        this.date = date;
    }

    public MenuDTO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

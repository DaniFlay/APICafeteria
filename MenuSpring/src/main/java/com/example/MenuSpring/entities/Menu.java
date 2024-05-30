package com.example.MenuSpring.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Menus")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate date;
    @Column
    private Double totalPrice;
    @OneToMany(mappedBy = "menu")
    private List<Dish> dishes;
    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> clientOrders) {
        this.dishes = clientOrders;
    }

    public Menu(Long id, LocalDate date, Double totalPrice, List<Dish> dishes) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.dishes = dishes;
    }
}

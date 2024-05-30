package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.DishDTO;
import com.example.MenuSpring.entities.Dish;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DishServiceInterface {
    public List<DishDTO> findAllDishes();
    public ResponseEntity<Dish> add(DishDTO dish);
    public Optional<Dish> findById(Long id);
    public List<DishDTO> findByDate(LocalDate date);
    public Dish delete(Long id);
    public void edit(Dish dish);
    public List<Dish> findAllDishesAdmin();
}

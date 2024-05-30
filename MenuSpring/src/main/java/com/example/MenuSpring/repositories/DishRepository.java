package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Long> {
    List<Dish> findByDate(LocalDate date);
}

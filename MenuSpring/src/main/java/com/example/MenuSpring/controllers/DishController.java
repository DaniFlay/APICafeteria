package com.example.MenuSpring.controllers;

import com.example.MenuSpring.dto.DishDTO;
import com.example.MenuSpring.entities.Dish;
import com.example.MenuSpring.services.DishService;
import com.example.MenuSpring.services.MenuService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/dish")
public class DishController {
    private final Logger log= LoggerFactory.getLogger(DishController.class);
    @Autowired
    private DishService dishService;

    @GetMapping("/all")
    public List<DishDTO> findAllDishes(){
        return dishService.findAllDishes();
    }
    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody DishDTO dish){
       return dishService.add(dish);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<DishDTO> findById(@PathVariable("id") Long id){
        Optional<Dish> dish= dishService.findById(id);
        if(dish.isPresent()){
            Dish d = dish.get();
            return ResponseEntity.ok(new DishDTO(d.getName(),d.getPrice(),d.getType(),d.getDate()));
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<DishDTO>> findByDate(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDate = LocalDate.parse(date, formatter);
        return ResponseEntity.ok(dishService.findByDate(formatDate));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Dish> delete (@PathVariable Long id){
        return ResponseEntity.ok(dishService.delete(id));
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Dish dish){
         dishService.edit(dish);
    }
    @GetMapping("/fulldishes")
    public ResponseEntity<List<Dish>> dishesAdmin(){
        return ResponseEntity.ok(dishService.findAllDishesAdmin());
    }
}

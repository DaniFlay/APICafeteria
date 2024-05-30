package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.DishDTO;
import com.example.MenuSpring.entities.Dish;
import com.example.MenuSpring.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService implements DishServiceInterface{
    @Autowired
    DishRepository dishRepository;
    @Override
    public List<DishDTO> findAllDishes() {
        List<DishDTO> dishListRep= new ArrayList<>();
        List<Dish> fullDishes= dishRepository.findAll();
        for(Dish d: fullDishes){
            dishListRep.add(new DishDTO(d.getName(),d.getPrice(),d.getType(),d.getDate()));
        }
        return dishListRep;
    }

    @Override
    public ResponseEntity<Dish> add(DishDTO dish) {
        return ResponseEntity.ok(dishRepository.save(new Dish(null, dish.getName(),dish.getPrice(),dish.getDate(),dish.getType())));
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);

    }

    @Override
    public List<DishDTO> findByDate(LocalDate date) {
        List<Dish> allDishes= dishRepository.findAll();
        List<DishDTO> dishRep= new ArrayList<>();
        for(Dish d: allDishes){
            if(d.getDate().equals(date)){
                dishRep.add(new DishDTO(d.getName(),d.getPrice(),d.getType(),d.getDate()));
            }
        }
        return dishRep;
    }

    @Override
    public Dish delete(Long id) {
        Dish dish= null;
        Optional<Dish> d= dishRepository.findById(id);
        if(d.isPresent()){
            dish= d.get();
            dishRepository.deleteById(id);
        }
        return dish;
    }

    @Override
    public void edit(Dish dish) {
        Optional<Dish> d= dishRepository.findById(dish.getDishId());
        if(d.isPresent()){
            dishRepository.save(dish);
        }
    }

    @Override
    public List<Dish> findAllDishesAdmin() {
        return dishRepository.findAll();
    }
}

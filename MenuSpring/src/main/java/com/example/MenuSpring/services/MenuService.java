package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Dish;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.DishRepository;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService implements MenuServiceInterface {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu add(MenuDTO menuDTO
    ) {
        Optional<Menu> m= menuRepository.findByDate(menuDTO.getDate());
        m.ifPresent(menu -> menuRepository.delete(menu));
        List<Dish> dishes= dishRepository.findByDate(menuDTO.getDate());
        Menu menu = new Menu(null, menuDTO.getDate(), menuDTO.getPrice(), dishes);
        return menuRepository.save(menu);
    }

    @Override
    public Menu findToday() {
        Optional<Menu> menu= menuRepository.findByDate(LocalDate.now());
        Menu m = null;
        if(menu.isPresent()){
            m= menu.get();
            m.setDishes(dishRepository.findByDate(LocalDate.now()));
        }
        
        return m;
    }
    @Override
    public Menu findByDate(LocalDate date) {
        Optional<Menu> menu= menuRepository.findByDate(date);
        Menu m= null;
        if(menu.isPresent()){
           m= menu.get();
           m.setDishes(dishRepository.findByDate(date));
        }
        return m;
    }

    @Override
    public Menu findById(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()){
            return menu.get();
        }
        return null;
    }

    @Override
    public Menu edit(Menu m) {
        Menu menu= findById(m.getId());
        menu.setTotalPrice(m.getTotalPrice());
        menu.setDate(m.getDate());
        menu.setDishes(m.getDishes());
        return menuRepository.save(menu);
    }


}

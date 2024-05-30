package com.example.MenuSpring.services;

import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.repositories.MenuRepository;
import org.springframework.http.ResponseEntity;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MenuServiceInterface {
    public List<Menu> findAll();
    Menu add(MenuDTO menuDTO
    );
    public Menu findToday();
    public Menu findByDate(LocalDate date);
    public Menu findById(Long id);
    public Menu edit(Menu menu);
}

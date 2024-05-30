package com.example.MenuSpring.controllers;
import com.example.MenuSpring.dto.MenuDTO;
import com.example.MenuSpring.entities.Menu;
import com.example.MenuSpring.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/menu")
public class MenuController {
    private final Logger log= LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

    @GetMapping("/today")
    public ResponseEntity<Menu> findTodaysMenu(){
        return ResponseEntity.ok(menuService.findToday());
    }
    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody MenuDTO menuDTO){
            return ResponseEntity.ok(menuService.add(menuDTO));


    }
    @GetMapping("/date/{date}")
    public ResponseEntity<Menu> findMenuByDate(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDate = LocalDate.parse(date, formatter);
        Menu menu= menuService.findByDate(formatDate);
        return ResponseEntity.ok(menu);


    }
    @PutMapping("/edit")
    public ResponseEntity<Menu> editMenu(@RequestBody Menu m){
        return ResponseEntity.ok(menuService.edit(m));
    }

}

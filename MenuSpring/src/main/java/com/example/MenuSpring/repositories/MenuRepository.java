package com.example.MenuSpring.repositories;

import com.example.MenuSpring.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByDate(LocalDate date);

}

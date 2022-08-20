package com.ibm.restaurant.infrastructure.menu;

import com.ibm.restaurant.domain.menu.MenuItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMenuItemRepositorySdj extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByItemNameContainingIgnoreCase(String itemName, Pageable page);

    List<MenuItem> findByDescriptionContainingIgnoreCase(String description, Pageable page);

}

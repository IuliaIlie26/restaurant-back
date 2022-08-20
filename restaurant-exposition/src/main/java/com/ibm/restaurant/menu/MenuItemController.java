package com.ibm.restaurant.menu;

import com.ibm.restaurant.application.menu.MenuItemService;
import com.ibm.restaurant.domain.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemMapperService mapper;
    @Autowired
    private MenuItemService service;

    @PostMapping
    public ResponseEntity<Void> createMenuItem(@RequestBody final MenuItemDto menuItemDto) {
        MenuItem domainObj = mapper.mapToDomain(menuItemDto);
        try {
            service.createMenuItem(domainObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public ResponseEntity<List<MenuItemDto>> findAll(@PathParam("description") final String description, @PathParam("pageNumber") final Integer pageNumber,
                                     @PathParam("nrOfItems") final Integer nrOfItems) {
        List<MenuItem> items = service.findAll(description, pageNumber, nrOfItems);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapFromDomain(items));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDto> findById(@PathVariable("id") final Long id) {
        MenuItem menuItem = service.findById(id);
        MenuItemDto response = mapper.mapFromDomain(menuItem);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("")
    public ResponseEntity<MenuItemDto> updateMenuItem(@RequestBody final MenuItemDto menuItemDto) {
        return Optional.ofNullable(mapper.mapToDomain(menuItemDto))
                .map(domainObj -> {
                    MenuItem updatedObj = service.updateMenuItem(domainObj);
                    MenuItemDto response =  mapper.mapFromDomain(updatedObj);
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                })
                .orElse(null);
    }

    @DeleteMapping(("/{id}"))
    public ResponseEntity<Void> deleteMenuItem(final Long id) {
        service.deleteMenuItem(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

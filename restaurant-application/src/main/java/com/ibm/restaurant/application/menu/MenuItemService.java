package com.ibm.restaurant.application.menu;

import com.ibm.restaurant.domain.menu.IMenuItemRepository;
import com.ibm.restaurant.domain.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private IMenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(MenuItem menuItem) throws Exception {
        return Optional.ofNullable(menuItemRepository.createMenuItem(menuItem))
                .orElseThrow(() -> new Exception("Unable to create menu item"));
    }

    public MenuItem findById(Long id) {
        return menuItemRepository.findById(id);
    }

    public MenuItem updateMenuItem(MenuItem menuItem) {
        MenuItem item = menuItemRepository.findById(menuItem.getId());

        if(item != null) {
            item.setDescription(menuItem.getDescription());
            item.setPrice(menuItem.getPrice());
            item.setItemName(menuItem.getItemName());

            return menuItemRepository.updateMenuItem(item);

        }
       return null;
    }

    public void deleteMenuItem(Long id) {
        MenuItem oldItem = menuItemRepository.findById(id);
        if(oldItem != null) {
            menuItemRepository.deleteMenuItem(oldItem);
        }
    }

    public List<MenuItem> findAll(String description, Integer pageNumber, Integer nrOfItems) {
        if(pageNumber == null) {
            pageNumber = 0;
        }

        if(nrOfItems == null) {
            nrOfItems = 10;
        }

        return menuItemRepository.findAll(description, pageNumber, nrOfItems);
    }

}

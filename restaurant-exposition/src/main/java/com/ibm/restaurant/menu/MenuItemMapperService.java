package com.ibm.restaurant.menu;

import com.ibm.restaurant.domain.menu.MenuItem;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuItemMapperService {
    public MenuItemDto mapFromDomain(final MenuItem menuItem) {
        if (menuItem != null) {
            MenuItemDto menuItemDto = new MenuItemDto();
            menuItemDto.id = menuItem.getId();
            menuItemDto.description = menuItem.getDescription();
            menuItemDto.itemName = menuItem.getItemName();
            menuItemDto.price = menuItem.getPrice();

            return menuItemDto;
        }

        return null;
    }

    public List<MenuItemDto> mapFromDomain(final List<MenuItem> input) {
        if (input != null && !input.isEmpty()) {
            return input.stream()
                    .map(item -> mapFromDomain(item)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public MenuItem mapToDomain(final MenuItemDto menuItemDto) {
        MenuItem response = new MenuItem(menuItemDto.itemName, menuItemDto.price, menuItemDto.description);
        response.setId(menuItemDto.id);
        return response;
    }

    public Set<MenuItem> mapItemListToDomain(Set<MenuItemDto> menuItemDtos) {
        return menuItemDtos.stream().map(this::mapToDomain).collect(Collectors.toSet());
    }
}

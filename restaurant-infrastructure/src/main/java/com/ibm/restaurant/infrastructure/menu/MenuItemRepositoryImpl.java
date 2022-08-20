package com.ibm.restaurant.infrastructure.menu;

import com.ibm.restaurant.domain.menu.IMenuItemRepository;
import com.ibm.restaurant.domain.menu.MenuItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuItemRepositoryImpl implements IMenuItemRepository {

    @Autowired
    private IMenuItemRepositorySdj repositorySdj;

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return repositorySdj.save(menuItem);
    }

    @Override
    public MenuItem findById(Long id) {
        return repositorySdj.findById(id).orElse(null);
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
        return repositorySdj.save(menuItem);
    }

    @Override
    public void deleteMenuItem(MenuItem menuItem) {
        repositorySdj.delete(menuItem);
    }

    @Override
    public List<MenuItem> findAll(String description, Integer pageNumber, Integer nrOfItems) {
        Pageable request = PageRequest.of(pageNumber, nrOfItems);

        if (StringUtils.isEmpty(description)) {
            return Optional.ofNullable(repositorySdj.findAll(request))
                    .map(result -> result.getContent())
                    .orElse(Collections.emptyList());
        } else {
            List<MenuItem> filteredByName = repositorySdj.findByItemNameContainingIgnoreCase(description, request);

            if (!filteredByName.isEmpty()) {
                return filteredByName;
            } else {
                return repositorySdj.findByDescriptionContainingIgnoreCase(description, request);
            }
        }
    }
}
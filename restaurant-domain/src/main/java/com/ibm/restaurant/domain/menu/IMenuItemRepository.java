package com.ibm.restaurant.domain.menu;

import java.util.List;

public interface IMenuItemRepository {

    MenuItem createMenuItem(final MenuItem menuItem);

    MenuItem findById(final Long id);

    List<MenuItem> findAll(String description, final Integer pageNumber, Integer nrOfItems);

    MenuItem updateMenuItem(final MenuItem menuItem);

    void deleteMenuItem(final MenuItem menuItem);

}

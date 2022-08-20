package com.ibm.restaurant.domain.tables;

import java.util.HashSet;

public interface ITableRepository {

    void createTable(Table table);

    Table getTableById(Long id);

    HashSet<Table> getTableList();

    void updateTable(Table table);

    void deleteTable(Table table);
}

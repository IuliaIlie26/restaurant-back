package com.ibm.restaurant.infrastructure.tables;

import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class TableRepositoryImpl implements ITableRepository {

    @Autowired
    private ITableRepositorySdj repositorySdj;

    @Override
    public void createTable(Table table) {
        repositorySdj.save(table);
    }

    @Override
    public Table getTableById(Long id) {
        return repositorySdj.findById(id).orElse(null);
    }

    public HashSet<Table> getTableList() {

        return new HashSet<>(repositorySdj.findAll());
    }

    @Override
    public void updateTable(Table table) {
        repositorySdj.save(table);
    }

    @Override
    public void deleteTable(Table table) {
        repositorySdj.delete(table);
    }
}

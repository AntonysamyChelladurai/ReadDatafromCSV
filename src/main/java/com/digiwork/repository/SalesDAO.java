package com.digiwork.repository;

import com.digiwork.core.Sales;

import java.util.List;

public interface SalesDAO {
    int save(Sales salse);
    int update(Sales salse);
    Sales findById(Long id);
    int deleteById(Long id);
    List<Sales> findAll();
   /* List<Sales> findByPublished(boolean published);
    List<Sales> findByTitleContaining(String title);*/
    int deleteAll();
}

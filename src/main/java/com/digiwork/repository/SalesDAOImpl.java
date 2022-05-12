package com.digiwork.repository;

import com.digiwork.core.Sales;
import com.digiwork.jdbc.Datasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.List;


public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_SALE = "INSERT INTO first.\"Sales\"(\n" +
            "\t\"orderDate\", city, state, type, units, \"unitCost\", total, \"orderID\")\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);";



    private Connection getConnection(){
        Datasource dbcon = new Datasource();
        Connection con =dbcon.connect();
        return con;
    }



    @Override
    public int save(Sales salse) {
        Connection con=getConnection();
        jdbcTemplate.update(SQL_INSERT_SALE,salse.getOrderDate(), salse.getCity(),salse.getState(),salse.getType(),salse.getUnits(),salse.getUnitCost(),salse.getOrderID());
        System.out.println("New Row Inserted :: ");
        return 0;
    }

    @Override
    public int update(Sales salse) {
        return 0;
    }

    @Override
    public Sales findById(Long id) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public List<Sales> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}

package com.digiwork.model;


import com.digiwork.core.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesMapper implements RowMapper<Sales> {
    @Autowired
    Sales sale;

    @Override
    public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {

        Sales sale = new Sales();

        return null;
    }
}

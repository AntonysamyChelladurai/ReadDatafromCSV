package com.digiwork.repository;

import com.digiwork.core.Sales;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface SalesDAO {
    int save(Sales salse) throws SQLException, ParseException;
}

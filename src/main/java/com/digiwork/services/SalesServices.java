package com.digiwork.services;

import com.digiwork.core.Sales;
import com.digiwork.repository.SalesDAOImpl;
import java.sql.SQLException;
import java.text.ParseException;
public class SalesServices {
    SalesDAOImpl salesDAO = new SalesDAOImpl();
    public void addData(Sales sales) {
        try {
            salesDAO.save(sales);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

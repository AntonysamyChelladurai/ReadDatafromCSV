package com.digiwork.repository;

import com.digiwork.core.Sales;
import com.digiwork.jdbc.Datasource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesDAOImpl implements SalesDAO {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    Datasource datasource = new Datasource();
    private final String SQL_INSERT_SALE ="INSERT INTO first.\"Sales\"(\n" +
            "\tcity, state, type, \"unitsSold\", \"TotalRevenue\", \"orderID\", orderdate, \"unitCost\", \"TotalCost\", \"TotalProfit\", \"ItemType\", \"SalesChannel\", \"OrderPriority\", \"UnitSellPrice\")\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    @Override
    public int save(Sales salse) throws SQLException, ParseException {

        Datasource ds = datasource.getInstance();
        System.out.println("My Singleton Instance hashCode :: "+ds.hashCode());
        Connection con = ds.getConnection();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date parsed = format.parse(salse.getOrderDate());
        java.sql.Date sql_date = new java.sql.Date(parsed.getTime());
        PreparedStatement preparedStatement=con.prepareStatement(SQL_INSERT_SALE);
        preparedStatement.setString(1,salse.getCity());
        preparedStatement.setString(2,salse.getState());
        preparedStatement.setString(3,salse.getType());
        preparedStatement.setInt(4, salse.getUnitsSold());
        preparedStatement.setDouble(5,salse.getTotalRevenue());
        preparedStatement.setString(6,salse.getOrderID());
        preparedStatement.setDate(7, sql_date);
        preparedStatement.setDouble(8, salse.getUnitCost());
        preparedStatement.setDouble(9,salse.getTotalCost());
        preparedStatement.setDouble(10,salse.getTotalProfit());
        preparedStatement.setString(11,salse.getItemType());
        preparedStatement.setString(12,salse.getSalesChannel());
        preparedStatement.setString(13,salse.getOrderPriority());
        preparedStatement.setDouble(14,salse.getUnitSellPrice());
        int result=preparedStatement.executeUpdate();
        System.out.println("New Row Inserted :: "+ result);
        return 0;
    }

    /*@Override
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
    }*/
}

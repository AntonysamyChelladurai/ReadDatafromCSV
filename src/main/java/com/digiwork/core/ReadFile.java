package com.digiwork.core;

import com.digiwork.services.SalesServices;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        System.out.println("Reading from CSV file using BufferedReader and String Split");
        List<Sales> sales = readCSV();
        print(sales);
        System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
    }

    private static void print(List<Sales> sales) {
        System.out.println("========================");
        for (Sales sale : sales) {
            System.out.println(sale);
        }
        System.out.println("========================");

    }

    private static List readCSV() throws IOException {
        List<Sales> salesList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/antonychelladurai/Downloads/Saleslist2.csv"));
        String line = br.readLine();
        // Reading header, Ignoring
        int i = 0;
        Sales sale = new Sales();
        while ((line = br.readLine()) != null && !line.isEmpty() ) {
            String[] fields = line.split(",");
                try {
                    sale.setOrderID(fields[0]);
                    sale.setOrderDate(fields[1]);
                    sale.setItemType(fields[2]);
                    sale.setSalesChannel(fields[3]);
                    sale.setOrderPriority(fields[4]);
                    sale.setCity(fields[5]);
                    sale.setState(fields[6]);
                    sale.setType(fields[7]);
                    sale.setUnitsSold(Integer.parseInt(fields[8]));
                    sale.setUnitCost(Double.parseDouble(fields[9]));
                    sale.setUnitSellPrice(Double.parseDouble(fields[10]));
                    sale.setTotalRevenue(Double.parseDouble(fields[11]));
                    sale.setTotalCost(Double.parseDouble(fields[12]));
                    sale.setTotalProfit(Double.parseDouble(fields[13]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
            }
            salesList.add(sale);
            SalesServices salesServices = new SalesServices();
            salesServices.addData(sale);
            i++;
            System.out.println("index :: " + i);
        }
        br.close();
        return salesList;
    }

}

package com.digiwork.core;

import com.digiwork.repository.SalesDAOImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        System.out.println("Reading from CSV file using BufferedReader and String Split");
        List<Sales> sales = readCSV();
        //saleimpl.save(sales.get(0));

        print(sales);
        System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
        //parseCSV();
        /*DBConnection con = new DBConnection();
        Connection cn =con.connect();*/

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
        BufferedReader br = new BufferedReader( new FileReader("/Users/antonychelladurai/Downloads/Saleslist.csv"));
        String line = br.readLine();
        // Reading header, Ignoring
        int i=0;
        String orderID ;
        String orderDate;
        String city;
        String state;
        String type;
        double units=0;
        double unitCost=0;
        double total=0;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
             orderDate = fields[0];
             city= fields[1];
             state= fields[2];
             type= fields[3];
            try {
                 units = Double.parseDouble(fields[4]);
                 unitCost = Double.parseDouble(fields[5]);
                 total = Double.parseDouble(fields[6]);
            }
            catch (NumberFormatException e){
                e.printStackTrace();
            }
            orderID= String.valueOf(i*1000);
            Sales sale = new Sales(orderID,orderDate, city, state,type, units, unitCost,total);
            salesList.add(sale);
            i++;
            System.out.println("index :: "+ i);
        }
        br.close();
        return salesList;
}

    private static void parseCSV() throws IOException {
        CSVParser parser = new CSVParser(new FileReader("/Users/antonychelladurai/Downloads/OfficeSupply.csv"), CSVFormat.DEFAULT.withHeader());
        for (CSVRecord record : parser) {
            System.out.printf("%s\t%s\t%s\n", record.get("NAME"), record.get("CAPITAL"), record.get("CURRENCY"));
        }
        parser.close();
 }

   /* @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class Sales{
        private String orderDate;
        private String city;
        private String state;
        private String type;
        private double units;
        private double unitCost;
        private double total;
    }*/
}

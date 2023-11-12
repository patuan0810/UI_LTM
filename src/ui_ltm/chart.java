/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui_ltm;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author user
 */
public class chart extends javax.swing.JFrame {

    /**
     * Creates new form chart
     */
    private static JFreeChart barChart;
    public static JFreeChart createChart(String data) {
        barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ BIẾN ĐỘNG GIÁ CỦA SẢN PHẨM",
                "Ngày", "Giá",
                createDataset(data), PlotOrientation.VERTICAL, false, false, false);
        
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        plot.getRenderer().setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        plot.getRenderer().setBaseItemLabelsVisible(true);
        //Hiển thị giá trên cột
        return barChart;
    }

    private static CategoryDataset createDataset(String data) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JSONArray arrListDateAndPrice = new JSONArray(data);
        System.out.println("Đang trong chart với data:" + arrListDateAndPrice.toString());
        for (int i = 0; i < arrListDateAndPrice.length(); i++) {
            JSONObject contentPriceAndDate = arrListDateAndPrice.getJSONObject(i);
           
            double price = contentPriceAndDate.getDouble("price");
            int priceInt = (int) price;
            
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String searchDate = contentPriceAndDate.getString("searchDate");
            
            Date oldFormatDate;
            try {
                oldFormatDate = oldDateFormat.parse(searchDate);
                String newFormatDate = newDateFormat.format(oldFormatDate);
                dataset.addValue(priceInt, "", newFormatDate);
                System.out.println("price: " + priceInt + "\n" + "searchDateFormat: " + searchDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
//            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
//            double priceFormat = Double.valueOf(decimalFormat.format(price ));
            
        } 
      
//        dataset.addValue(100000, "", "1/2023");
//        dataset.addValue(850000, "", "2/2023");
//        dataset.addValue(200000, "", "3/2023");
//        dataset.addValue(300000, "", "4/2023");
//        dataset.addValue(400000, "", "5/2023");
//        dataset.addValue(500000, "", "6/2023");
//        dataset.addValue(600000, "", "7/2023");
//        dataset.addValue(700000, "", "8/2023");
//        dataset.addValue(800000, "", "9/2023");
//        dataset.addValue(900000, "", "10/2023");
//        dataset.addValue(1000000, "", "11/2023");
//        dataset.addValue(1000000, "", "12/2023");
        return dataset;
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
       public static void main(String[] args) {
        ChartPanel chartPanel = new ChartPanel(createChart("data"));
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

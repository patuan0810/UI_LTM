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
import org.json.JSONException;
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

    // Check if the data starts with '[' before creating a JSONArray
    if (data.startsWith("[")) {
        try {
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
            }
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle the case when the data is not in JSON array format
            System.err.println("Invalid JSON array format in data");
        }
    } else {
        // Handle the case when the data does not start with '['
        System.err.println("Invalid JSON array format in data");
    }

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

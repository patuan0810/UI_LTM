/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Admin
 */
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class ConnectDB {

    private static Connection conn = null;
    public static boolean getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Đăng ký(nạp) lớp "com.microsoft.sqlserver.jdbc.SQLServerDriver"
            //Đây là lớp driver JDBC cung cấp bởi Microsoft SQL Server để kết nối và tương tác với cơ sở dữ liệu SQL Server từ Java.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "sa";
        String pass = "123456";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TikiTrackPrice", user, pass);
            //Kết nối với SQL Server chạy trên localhost với port 1433
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn == null) {
            return false;
        } else {
            return true;
        }

    }

    public static String getCategory() {
        JSONObject jsCategory = new JSONObject();
        try {
            String sqlCategory = "Select CategoryID, CategoryName from category";
            Statement statement = conn.createStatement();
            //Tạo đối tượng "Statement" để thực thi câu lệnh SQL
            ResultSet rs = statement.executeQuery(sqlCategory);
            //Dùng đối tượng "Statement" thực thi câu lệnh SQL và lưu kết quả vào đối tượng "ResultSet"

            JSONArray arrCategory = new JSONArray();
            while (rs.next()) {
                JSONObject contentCategory = new JSONObject();
                contentCategory.put("CategoryID", rs.getString("CategoryID"));
                contentCategory.put("CategoryName", rs.getString("CategoryName"));
                arrCategory.put(contentCategory);
            }
            jsCategory.put("Success", "true");
            jsCategory.put("Category", arrCategory);
            return jsCategory.toString();
        } catch (Exception e) {
            jsCategory.put("Success", "false");
            jsCategory.put("Error", "Đã có lỗi lấy dữ liệu danh mục.");
            e.printStackTrace();
            return jsCategory.toString();
        }
    }

    public static String getPriceAndDate(String productID) {
        JSONObject jsPriceAndeDate = new JSONObject();
        try {
            String sqlPriceAndDate = "Select Price, SearchDate from final_product_detail where ProductID =" + productID;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlPriceAndDate);
            JSONArray arrPriceAndeDate = new JSONArray();

            while (rs.next()) {
                JSONObject contentPriceAndDate = new JSONObject();
                contentPriceAndDate.put("Price", rs.getString("Price"));
                contentPriceAndDate.put("SearchDate", rs.getString("SearchDate"));
                arrPriceAndeDate.put(contentPriceAndDate);
            }

            jsPriceAndeDate.put("Success", "true");
            jsPriceAndeDate.put("Price And Date", arrPriceAndeDate);
            return jsPriceAndeDate.toString();
        } catch (Exception e) {
            jsPriceAndeDate.put("Success", "false");
            jsPriceAndeDate.put("Error", "Đã có lỗi lấy dữ liệu giá và ngày tra cứu.");
            e.printStackTrace();
            return jsPriceAndeDate.toString();
        }

    }

    public static String getListProduct(String categoryID) {
        JSONObject jsListProduct = new JSONObject();
        try {
            String sqlCategory = "Select ProductID, Name from product where CategoryID = '" + categoryID + "' ORDER BY Name" ;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlCategory);

            JSONArray arrListProduct = new JSONArray();
            while (rs.next()) {
                JSONObject contentListProduct = new JSONObject();
                contentListProduct.put("productID", rs.getString("ProductID"));
                contentListProduct.put("name", rs.getString("Name"));
                arrListProduct.put(contentListProduct);
            }
            jsListProduct.put("list product", arrListProduct);
            return jsListProduct.toString();
        } catch (Exception e) {
            jsListProduct.put("Error", "Đã có lỗi lấy dữ liệu tên sản phẩm.");
            e.printStackTrace();
            return jsListProduct.toString();
        }
    }




}

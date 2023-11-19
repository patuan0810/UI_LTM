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
import org.json.JSONException;

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

public static String getListProduct(String categoryID) {
    JSONObject jsListProduct = new JSONObject();
    try {
        String sqlCategory = "SELECT ProductID, Name, ImageURL FROM product WHERE CategoryID = ? ORDER BY Name";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sqlCategory)) {
            preparedStatement.setString(1, categoryID);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                JSONArray arrListProduct = new JSONArray();
                while (rs.next()) {
                    JSONObject contentListProduct = new JSONObject();
                    String productID = rs.getString("ProductID");

                    contentListProduct.put("productID", productID);
                    contentListProduct.put("name", rs.getString("Name"));
                    contentListProduct.put("imageURL", rs.getString("ImageURL"));

                    arrListProduct.put(contentListProduct);
                }
                jsListProduct.put("list product", arrListProduct);
            }
        }
        return jsListProduct.toString();
    } catch (SQLException | JSONException e) {
        jsListProduct.put("Error", "Đã có lỗi lấy dữ liệu tên sản phẩm.");
        e.printStackTrace();
        return jsListProduct.toString();
    }
}


public static String getAllProducts() {
    JSONObject jsAllProducts = new JSONObject();
    try {
        String sqlAllProducts = "SELECT [ProductID], [Name], [ImageURL] FROM [TikiTrackPrice].[dbo].[product]";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sqlAllProducts);

        JSONArray arrAllProducts = new JSONArray();
        while (rs.next()) {
            JSONObject contentAllProducts = new JSONObject();

                     String productID = rs.getString("ProductID");

                    contentAllProducts.put("productID", productID);
                    contentAllProducts.put("name", rs.getString("Name"));
                    contentAllProducts.put("imageURL", rs.getString("ImageURL"));

            arrAllProducts.put(contentAllProducts);
        }
        jsAllProducts.put("list product", arrAllProducts);
        return jsAllProducts.toString();
    } catch (Exception e) {
        jsAllProducts.put("Error", "Đã có lỗi lấy dữ liệu sản phẩm.");
        e.printStackTrace();
        return jsAllProducts.toString();
    }
}





    public static String getListPriceAndDate(String productID) {
            String sqlPriceAndDate = "Select Price, SearchDate from final_product_detail where ProductID=" + productID + " ORDER BY SearchDate";
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sqlPriceAndDate);
                JSONObject jsListPriceAndDate = new JSONObject();
                JSONArray arrListPriceAndDate = new JSONArray();
            
                while (rs.next()) {
                   JSONObject contentListPriceAndDate = new JSONObject();
                   contentListPriceAndDate.put("price", rs.getString("Price"));
                   contentListPriceAndDate.put("searchDate", rs.getDate("SearchDate"));
                   arrListPriceAndDate.put(contentListPriceAndDate);
                }
                jsListPriceAndDate.put("ListPriceAndDate", arrListPriceAndDate);
                return jsListPriceAndDate.toString();
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }        
    }




}

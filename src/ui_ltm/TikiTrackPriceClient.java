/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui_ltm;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TikiTrackPriceClient {
    
    private static Socket socket;
    private static BufferedReader in;
    private static BufferedWriter  out;
    
    public TikiTrackPriceClient(int port) {
        
        try {
            socket = new Socket(getServerIP(), port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Client đã kết nối đến server " + socket.getRemoteSocketAddress());
            System.out.println("Khởi tạo Client thành công.");
        } catch(IOException e){
            System.out.println("Khởi tạo Client thất bại.");
            e.printStackTrace();
        }
        
    }
    
    public static String handleListProduct(String request, String data) {
        
        try {
            JSONObject jsDataSend = new JSONObject();
            jsDataSend.put("request", request);
            jsDataSend.put("data", data);
            out.write(jsDataSend.toString() + "\n");
            out.flush();
            String dataReceive = in.readLine();
            return dataReceive;
        } catch (IOException e) {
            e.printStackTrace();
            return "Đã có lỗi nhận dữ liệu!";
          
        }
    }
    
    public static String getServerIP() {
        try {
            String api = "https://retoolapi.dev/lyMHm1/data/1/";
            Document doc = Jsoup.connect(api)
                .ignoreContentType(true).ignoreHttpErrors(true)
                .header("Content-Type", "application/json")
                .method(Connection.Method.GET).execute().parse();
            JSONObject jsonObject = new JSONObject(doc.text());
            String ipServer = jsonObject.get("ip").toString();
            return ipServer;
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
        
    }
 
    

}

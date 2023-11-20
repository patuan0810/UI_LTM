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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private static RSA_Client rsa_client;
    private static AES_Client aes_client;
    
    public TikiTrackPriceClient(int port) {
        
        try {
            socket = new Socket(getServerIP(), port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            createRSA(receivePublicKeyRSA());
            sendKeyAESToServer();
            
            System.out.println("Client đã kết nối đến server " + socket.getRemoteSocketAddress());
            System.out.println("Khởi tạo Client thành công.");
        } catch(IOException e){
            System.out.println("Khởi tạo Client thất bại.");
            e.printStackTrace();
        }
        
    }
    
    public static String sendRequestToServer(String request, String data) {
        
        try {
            JSONObject jsDataSend = new JSONObject();
            jsDataSend.put("request", request);
            jsDataSend.put("data", data);
            out.write(aes_client.encrypt(jsDataSend.toString()) + "\n");
            out.flush();
            String dataReceive = aes_client.decrypt(in.readLine());
            return dataReceive;
        } catch (Exception e) {
            e.printStackTrace();
            return "Đã có lỗi nhận dữ liệu!";
          
        }
    }
    
    private static String receivePublicKeyRSA() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private static void createRSA(String publicKeyRSA) {
        rsa_client = new RSA_Client(publicKeyRSA);
    }
    
    private static void sendKeyAESToServer() {
        try {
            aes_client = new AES_Client();
            aes_client.init();
            String keyAES = aes_client.getKey();
            out.write(rsa_client.encrypt(keyAES) + '\n');
            out.flush();
        } catch (Exception e) {
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

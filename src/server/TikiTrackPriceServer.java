/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Admin
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
public class TikiTrackPriceServer {
    private static  int port = 4444;
    private static int numThread = 9;
    private static ServerSocket server = null;

    public static void main(String[] args) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        try {
            server = new ServerSocket(port);
            postIP();
            System.out.println("Start Server Success!");
            if (ConnectDB.getConnection()) {
                System.out.println("Connect Database success!");
            } else {
                System.out.println("Error Connect Database");
            }
            while (true) {
                Socket socket = server.accept();
                executor.execute(new Worker(socket));
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (server!=null) {
                server.close();
            }
            // Code trong finally sẽ được thực hiện dù có xảy ra ngoại lệ hay không
        }
    }
    
    public static void postIP() {
        try {
            Socket socketGetIP = new Socket("google.com", 443);
            String localIP = socketGetIP.getLocalAddress().toString().substring(1);

            String api = "https://retoolapi.dev/lyMHm1/data/1/"; // Ghi vào dòng 1 trong DB
            String jsonData = "{\"ip\":\"" + localIP + "\"}";
            Jsoup.connect(api)
                    .ignoreContentType(true).ignoreHttpErrors(true)
                    .header("Content-Type", "application/json")
                    .requestBody(jsonData)
                    .method(Connection.Method.PUT).execute();
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
}

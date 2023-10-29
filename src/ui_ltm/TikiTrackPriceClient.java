/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui_ltm;

import com.orsoncharts.util.json.JSONObject;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TikiTrackPriceClient {
    private static int destPort = 4444;
    
    private static DatagramSocket socket;
    private static DatagramPacket dpSend, dpReceive;
    private static InetAddress inetAdd;
    
    public TikiTrackPriceClient(String hostname) {
        
        try {
            inetAdd = InetAddress.getByName(hostname);
            socket = new DatagramSocket();
            System.out.println("Khởi tạo Client thành công.");
        } catch(IOException e){
            System.out.println("Khởi tạo Client thất bại.");
            e.printStackTrace();
        }
        
    }
    
    public static void sendData(String request, String data) {

        try {
            JSONObject jsDataSend = new JSONObject();
            jsDataSend.put("request", request);
            jsDataSend.put("data", data);
            byte[] dataSend = jsDataSend.toString().getBytes();
            dpSend = new DatagramPacket(dataSend, dataSend.length, inetAdd, destPort);
            socket.send(dpSend);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
   
    
    
//    private String receiveData() {
//        
//    }
}

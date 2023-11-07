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
public class TikiTrackPriceServer {
    private static  int port = 4444;
    private static int numThread = 9;
    private static ServerSocket server = null;

    public static void main(String[] args) throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(numThread);
        try {
            server = new ServerSocket(port);
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
}

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientTest {
    private static String host = "localhost";
    private static int port = 4444;
    private static Socket socket;

    public static void main(String[] args) throws IOException {
        try {
            socket = new Socket(host, port);
            System.out.println("Client connected");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while(true) {
                System.out.print("Client sent: ");
                input = stdIn.readLine();
                JSONObject jsDataSend = new JSONObject();
                jsDataSend.put("request", "GetListProduct");
                jsDataSend.put("data", input);
                out.write(jsDataSend.toString() + "\n");
                out.flush();

                String dataReceive = in.readLine();
                JSONObject jsReceive = new JSONObject(dataReceive);
                JSONArray arrReceive = new JSONArray(jsReceive.getJSONArray("list product"));
                for (int i = 0; i < arrReceive.length(); i++) {
                    JSONObject contentReceive = arrReceive.getJSONObject(i);
                    String test = contentReceive.getString("name");

                    System.out.println(test);
                }

            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if(socket!=null) {
                socket.close();
                System.out.println("Client socket closed");
            }
        }
    }
}
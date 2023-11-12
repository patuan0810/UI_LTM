/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

/**
 *
 * @author Admin
 */
import org.json.JSONObject;
import java.io.*;
import java.net.Socket;

public class Worker implements Runnable { //triển khai các phương thức có trong Runnable, cụ thể là phương thức run()
    private Socket socket;

    private BufferedReader in;
    private BufferedWriter out;
    public Worker(Socket s) {
        this.socket = s;
    }

    public void run() {
        System.out.println("Client " + socket.toString() + " accepted");

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String dataSend = "";
            String isSendData = "";
            while (true) {

                dataSend = processData();
                isSendData = sendDataClient(dataSend);
                if (isSendData.equals("true")) {
                    System.out.println("The server has successfully sent data to " + socket.toString());
                } else if(isSendData.equals("false")) {
                    System.out.println("There was an ERROR sending data to the client" + socket.toString());
                } else {
                    System.out.println(isSendData);
                    break;
                }
            }
            closeSocket();
        } catch (IOException e) {
                System.out.println(e);
        }

    }


    public String sendDataClient(String dataSend) {
        try {
            out.write(dataSend + "\n");
            out.flush();
            return "true";
        } catch (IOException e) {
                //Kiểm tra xem có phải la lỗi kết nối socket ở phía client không
            if (e.getMessage().contains("Connection reset") || e.getMessage().contains("Connection reset by peer")) {
                return "The client has closed the socket!";
            }
            System.out.println(e);
            return "false";
        }


    }

    private String processData() {
        try {
            String dataReceive = in.readLine();
            JSONObject jsReceive = new JSONObject(dataReceive);
            String request = jsReceive.getString("request");
            String data = jsReceive.getString("data");
            String dataSend = "";
//            System.out.println("test " + data );
            switch (request)
            {
                case "GetListProduct":
                    dataSend = getListProduct(data);
                    break;
                case "GetListPriceAndDate":
                    dataSend = getListPriceAndDate(data);
                    break;
//                case "GetImageURL":
//                    dataSend = getImageURL(data);
//                    break;

                default:
//                    return input[0];
            }
            
            return dataSend;
        } catch (IOException e) {
            System.out.println(e);
            return "Đã có lỗi xử lí dữ liệu";
        }


    }
    private String getListProduct(String categoryID) {
        return ConnectDB.getListProduct(categoryID);
    }

    private String getListPriceAndDate(String productID) {
        return ConnectDB.getListPriceAndDate(productID);
    }
    
    
    private void closeSocket()      {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

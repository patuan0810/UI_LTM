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
import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
            postIP();
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
    public void postIP() {
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

        // Check if the received data is not null or empty
        if (dataReceive == null || dataReceive.isEmpty()) {
            System.err.println("Error: Received data is null or empty.");
            return "Error: Received data is null or empty.";
        }

        JSONObject jsReceive = new JSONObject(dataReceive);

        // Check if the "request" key is present
        if (jsReceive.has("request")) {
            String request = jsReceive.getString("request");

            // Check if the "data" key is present
            if (jsReceive.has("data")) {
                String data = jsReceive.getString("data");
                String dataSend = "";

                switch (request) {
                    case "GetListProduct":
                        dataSend = getListProduct(data);
                        break;
                    case "GetListPriceAndDate":
                        dataSend = getListPriceAndDate(data);
                        break;
//                    case "GetReview":
//                        dataSend = getReview(data);
//                        break;
                    default:
                        // Handle unknown request
                        System.err.println("Error: Unknown request type.");
                        return "Error: Unknown request type.";
                }

                return dataSend;
            } else {
                // Handle the case when "data" key is missing
                System.err.println("Error: 'data' key not found in the received JSON.");
                return "Error: 'data' key not found in the received JSON.";
            }
        } else {
            // Handle the case when "request" key is missing
            System.err.println("Error: 'request' key not found in the received JSON.");
            return "Error: 'request' key not found in the received JSON.";
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "Error: Failed to read data from input stream.";
    } catch (JSONException e) {
        e.printStackTrace();
        return "Error: Failed to parse JSON data.";
    }
}

//    private String getReview(String productID) throws IOException {
//    try {
//        String reviewUrl = "https://tiki.vn/api/v2/reviews?product_id=" + productID;
//        Document reviewDoc = Jsoup.connect(reviewUrl)
//                .method(Connection.Method.GET)
//                .ignoreContentType(true)
//                .execute()
//                .parse();
//        JSONObject reviewData = new JSONObject(reviewDoc.text());
//        String responseText = reviewDoc.text();
//        System.out.println("Nội dung phản hồi từ API: " + responseText);
//        if (!reviewData.has("data") || reviewData.getJSONArray("data").isEmpty()) {
//            throw new NoDataException("Không có dữ liệu review.");
//        }
//
//        StringBuilder result = new StringBuilder();
//        JSONArray reviews = reviewData.getJSONArray("data");
//        int maxReviews = 10;
//        int reviewCount = Math.min(maxReviews, reviews.length());
//
//      
//
//        for (int i = 0; i < reviewCount; i++) {
//            JSONObject review = reviews.getJSONObject(i);
//            result.append("</br>- ").append(review.getString("content")).append("</br>");
//        }
//
//        return result.toString();
//    } catch (IOException e) {
//        e.printStackTrace();
//        return "Lỗi kết nối hoặc xử lý dữ liệu.";
//    }
//}

// Custom exception class for no data
class NoDataException extends RuntimeException {
    public NoDataException(String message) {
        super(message);
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

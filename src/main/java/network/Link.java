package network;
import java.net.*;
import java.io.*;

public class Link{
    public static void main(String... args) {
        String url = args[1];
        
    try{
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod(args[0]);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
        String inputLine;
        StringBuffer response = new StringBuffer();
    
        while ((inputLine = in.readLine()) != null) {
           response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

    }catch(IOException io){
        System.out.print(io.getMessage());
        }
    }
}
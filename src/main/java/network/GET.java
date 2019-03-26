package network;
import input.Seeker;

import java.net.*;
import java.io.*;

public class GET {
    public static void main(String... args) {
        String url = args[0];
    try{
        URL obj;
        HttpURLConnection connection;
        if(args.length == 4){
            obj = new URL(url + args[1] + "?" + args[2]);
            connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod(args[3]);
        }else{
            obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod(args[1]);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
        String inputLine;
        StringBuffer response = new StringBuffer();
    
        while ((inputLine = in.readLine()) != null) {
           response.append(inputLine);
        }
        in.close();
        System.out.println("RESPONSE : ");
        System.out.println(response.toString());
        Seeker.start();
    }catch(IOException io){
        System.out.println(io.getMessage());
        Seeker.start();
        }
    }
}
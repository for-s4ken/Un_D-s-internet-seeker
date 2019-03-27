package network;

import input.Seeker;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class INFO {

    public static void main(String... args) {



        try {
            URL obj = new URL(args[0]);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            System.out.println("BASIC INFO : ");
            System.out.println(connection.toString());
            System.out.println("REQUEST METHOD : " + connection.getRequestMethod());
            System.out.println("RESPONSE CODE : " + connection.getResponseCode());
            System.out.println("USING PROXY : " + connection.usingProxy());
            System.out.println("RESPONSE MESSAGE : " + connection.getResponseMessage());
            Seeker.start();
        } catch (IOException io) {
            System.out.println(io.getMessage());
            Seeker.start();
        }
    }
}

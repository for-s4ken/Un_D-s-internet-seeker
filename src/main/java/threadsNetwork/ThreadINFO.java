package threadsNetwork;

import input.Seeker;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThreadINFO {

    public static void main(String... args) {

        try{
            URL obj = new URL(args[0]);
            new Thread(() -> {
                try {
                    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                    System.out.println("BASIC INFO : ");
                    System.out.println(connection.toString());
                    System.out.println("REQUEST METHOD : " + connection.getRequestMethod());
                    System.out.println("RESPONSE CODE : " + connection.getResponseCode());
                    System.out.println("USING PROXY : " + connection.usingProxy());
                    System.out.println("RESPONSE MESSAGE : " + connection.getResponseMessage());
                    Seeker.start();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    Seeker.start();
                }
            }).run();
        }catch (MalformedURLException malf){
            System.out.println("Wrong or not full URL");
            Seeker.start();
        }
    }
}

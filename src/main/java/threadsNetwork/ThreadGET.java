package threadsNetwork;

import input.Seeker;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThreadGET {

    public static int connectionsCount;

    public static void main(String... args){

        try{

            URL obj = new URL(args[0]);

            for(int i = 0; i < connectionsCount; i++){
                new Thread(() -> {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                        connection.setRequestMethod("GET");

                        System.out.println("CODE :" + connection.getResponseCode() + " , " + connection.getResponseMessage());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }).run();
            }
                Seeker.start();
        }catch (MalformedURLException malf){
            System.out.println("Wrong or not full URL");
            Seeker.start();
        }
    }
}


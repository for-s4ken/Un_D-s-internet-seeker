package threadsNetwork;

import input.Seeker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThreadGET {

    public static void main(String... args){

        try{

            URL obj = new URL(args[0]);

            new Thread(() -> {
                try {
                    HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                    connection.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    in.close();

                    System.out.println(response.toString());
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


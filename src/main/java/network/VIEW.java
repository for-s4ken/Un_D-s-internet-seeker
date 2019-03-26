package network;

import input.Seeker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class VIEW {
    public static void main(String... args) {
        try{
            URL obj = new URL(args[0]);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            File f = new File(System.getProperty("user.dir") + "//saved.html");
            String encoding = System.getProperty("console.encoding", "windows-1251");
            PrintWriter writer = new PrintWriter("saved.html", encoding);
            writer.println(response);
            System.out.println("FILE NAME : " + f.getName());
            Seeker.start();
        }catch(IOException io){
            System.out.println(io.getMessage());
            Seeker.start();
        }
    }
}

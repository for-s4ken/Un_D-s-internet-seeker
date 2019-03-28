package network;

import input.Seeker;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class POST {

    private static String url;

    public static void setUrl(String toSet){url = toSet;}

    public static void main(String... args){



        String inputLine;

        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // ADDING HEADERS

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty( "charset", "utf-8");
            con.setRequestProperty( "Content-Length", Integer.toString(args.length));
            con.setUseCaches(false);

            try( DataOutputStream wr = new DataOutputStream( con.getOutputStream())) {
                wr.writeChars(Arrays.toString(args));
            }

            ////////////////


                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                System.out.println("RESPONSE : ");
                System.out.println(response.toString());
                Seeker.start();

        }catch (IOException io){
            System.out.println(io.getMessage());
            Seeker.start();
        }
    }
}

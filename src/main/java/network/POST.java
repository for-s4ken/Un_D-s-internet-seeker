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

    public static void main(String... args){



        String inputLine;

        try {
            String url = args[0];
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // ADDING HEADERS

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

package network;

import input.Seeker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class POST {

    private static String url;

    public static void setUrl(String toSet){url = toSet;}

    public static void main(String... args){

        String inputLine;


        // String array ==> LinkedHashMap<String, String> ==> StringBuilder


        Map<String,String> params = new LinkedHashMap<>();

        if(args.length > 1){
            for(int i = 0; i < args.length; i++){
                params.put(args[i], args[++i]);
            }
        }else{
            System.out.println("No variables to send");
            Seeker.start();
        }

        System.out.println(params.toString());

        try {

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,String> param : params.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }


         ///////////////////////////////////////////////////////////////////


            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // ADDING HEADERS

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty( "charset", "utf-8");
            con.setRequestProperty( "Content-Length", Integer.toString(args.length));
            con.setUseCaches(false);

            // StringBuilder ==> Byte array

            try( DataOutputStream wr = new DataOutputStream( con.getOutputStream())) {
                wr.write(postData.toString().getBytes("UTF-8"));
            }
            con.connect();

            ////////////////


                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println("RESPONSE : ");
                System.out.println(response);

                // SAVING FILE

                System.out.println("Save response into .json? (Y/n)");
                Scanner keyboard = new Scanner(System.in);
                char answer = keyboard.next().charAt(0);
                if(answer == 'y' || answer == 'Y'){
                    File f = new File(System.getProperty("user.dir") + "//saved.json");
                    String encoding = System.getProperty("console.encoding", "windows-1251");
                    PrintWriter writer = new PrintWriter("saved.json", encoding);
                    writer.println(response);
                    System.out.println("FILE NAME : " + f.getName());
                    writer.flush();
                    writer.close();
                    Seeker.start();
                }else{
                    Seeker.start();
                }


        }catch (IOException io){
            System.out.println(io.getMessage());
            Seeker.start();
        }
    }
}

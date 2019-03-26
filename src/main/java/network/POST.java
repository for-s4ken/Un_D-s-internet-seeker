package network;

import input.Seeker;
import model.Variable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class POST {

    // HEADERS FOR POST METHOD

    private static ArrayList<Variable> variables;

    public static void addVariable(String key, String value){
        variables.add(new Variable(key, value));
    }

    /////////////////////////

    public static void main(String... args){


        try {
            String url = args[0];
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            // ADDING HEADERS

            for(int i = 0; i < variables.size(); i++){
                con.addRequestProperty(variables.get(i).getKey(), variables.get(i).getValue());
            }
        }catch (IOException io){
            System.out.println(io.getMessage());
            Seeker.start();
        }
    }
}

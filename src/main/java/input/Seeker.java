package input;
import network.GET;

import java.io.IOException;
import java.util.Scanner;
import static input.Resources.*;

public class Seeker{

    // INITIALIZATION

    private static String userInput;
    private static String URL;
    private static String command;
    private static String methodName;
    private static String variables;
    /////

    public static void main(String... args){
        try {
            clearConsole();
        }catch(IOException io){
            System.out.println("Can`t clear the console!!");
        }catch (InterruptedException interrupt){
            System.out.println("Can`t clear the console!!");
        }
          System.out.println("Welcome to the Un_D`s internet seeker!");
          start();
        }

    // STARTING METHOD

    public static void start(){
        System.out.println("Please enter command, or 'help' for available commands");
        setInput();
         while (userInput != null){
             if(userInput.equals("help")){
                 System.out.println("Available commands : ");
                 for(int i = 0;i < getCommands().length; i++){
                     System.out.println(getCommands()[i]);
                 }
                 setInput();
             }else if(userInput.equals("quit")){
                 System.exit(1337);
             }else if(userInput.equals("get")) {
                 System.out.println("Please enter full URL or IP address");
                 setURLInput("GET");
                 break;
             }else if(userInput.equals("method")) {
                 System.out.println("Please enter full URL or IP address");
                 setURLInput("METHOD");
                 break;
             }else if(userInput.equals("post")){
                 System.out.println("Please enter full URL or IP address");
                 setURLInput("POST");
                 break;
             }else{
                 System.out.println("Command not found");
                 setInput();
             }
         }
         if(URL != null && command.equals("GET")){
             GET.main(URL, "GET");
         }else if(URL != null && command.equals("METHOD")){
             GET.main(URL, methodName, variables, "GET");
         }
    }

    // CONSOLE INPUT

    static void setInput(){
        Scanner in = new Scanner(System.in);

        userInput = in.nextLine();
    }
    static void setURLInput(String arg){

        // METHOD VARIABLES INITIALIZING

        if(arg.equals("METHOD")) {
            Scanner in = new Scanner(System.in);
            URL = in.nextLine();
            System.out.println("Please enter method name");
            Scanner in2 = new Scanner(System.in);
            methodName = in2.nextLine();
            System.out.println("Please enter variables");
            Scanner in3 = new Scanner(System.in);
            variables = in3.nextLine();
            command = arg;
            System.out.println("Connecting...");

            //////////
        }else if(arg.equals("POST")){
            Scanner in = new Scanner(System.in);
            URL = in.nextLine();
            System.out.println("Please enter keys & values in form: \"key&value, key&value...\"");
            Scanner in2 = new Scanner(System.in);
            String toParse = in2.nextLine();
        }else{
            Scanner in = new Scanner(System.in);
            URL = in.nextLine();
            System.out.println("Connecting...");
            command = arg;
        }
    }
    public static void clearConsole() throws  IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
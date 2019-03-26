package input;
import network.Link;

import java.io.IOException;
import java.util.Scanner;
import static input.Resources.*;

public class Seeker{

    // INITIALIZATION

    private static String userInput;
    public static String URL;
    public static String command;

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

    static void start(){
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
             }else if(userInput.equals("get")){
                 System.out.println("Please enter full URL or IP address");
                 setURLInput();
                 break;
             }else{
                 System.out.println("Command not found");
                 setInput();
             }
         }
         if(URL != null && command.equals("GET")){
             Link.main(command, URL);
         }
    }

    // CONSOLE INPUT

    static void setInput(){
        Scanner in = new Scanner(System.in);

        userInput = in.nextLine();
    }
    static void setURLInput(){
        Scanner in = new Scanner(System.in);
        URL = in.nextLine();
        System.out.println("Connecting...");
        command = "GET";
    }
    public static void clearConsole() throws  IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
package com.myProject.Main;


import com.myProject.Observer.*;
import com.myProject.inputStrategies.*;
import java.util.Scanner;

public class Console extends ConcreteSubject implements Runnable {

    private Thread thread;
    private boolean running;
    private socketInput socketIn;
    private inputStream inputStream;
    private terminalInput terminalIn;
    private static Scanner in = null;

    Console() {
        in =  new Scanner(System.in);
        this.terminalIn = new terminalInput(in);
        this.inputStream = this.terminalIn;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    public synchronized void setSocket(String host, int port) { this.socketIn = new socketInput(host, port); }

//    public String[] parseInput(String userInput) {
//        String out[];
//        //splits the userInput into an array
//        String[] inputArr = userInput.split(" ");
//
//        if (userInput.equals(" ")) {
//            out = new String[] {"start"};
//        }
//        //checks if input is equal to the "mischief managed" and sets the output to "stop"
//        else if(userInput.toLowerCase().equals("test")) {
//            out = new String[] {"test"};
//        }
//        else if(userInput.toLowerCase().equals("mischief managed")) {
//            out = new String[] {"stop"};
//            this.running = false;
//        }
//        //checks if input is equal to the "look around" and sets the output to "look"
//        else if(userInput.toLowerCase().equals("look around")) {
//            out = new String[] {"look"};
//        }
//        else if(userInput.toLowerCase().equals("exit")) {
//            out = new String[] {"exit"};
//        }
//
//        //lol idk why this is there i guess for test purposes?? :')
//        else if(userInput.toLowerCase().equals("potato")) {
//            out = new String[] {"tomato"};
//        }
//
//        //checks if the first word is "use" and sets the output to "use", "...."
//        else if(inputArr[0].toLowerCase().equals("use")) {
//            out = new String[] { "use", userInput.substring(4).toLowerCase()};
//        }
//        //checks if the length is 2, first word is "walk" and sets the output to "walk", "...."
//        else if(inputArr.length == 2 && inputArr[0].toLowerCase().equals("walk")) {
//            out = new String[] { "walk", inputArr[1].toLowerCase()};
//        }
//        //checks if the length is 2 or more, first word is "talk", second is "to" and sets the output to "talk", "...."
//        else if(inputArr.length >= 2 && inputArr[0].toLowerCase().equals("talk") && inputArr[1].toLowerCase().equals("to")) {
//            out = new String[] { "talk", userInput.substring(8) };
//        }
//        else if(inputArr.length == 2 && inputArr[0].toLowerCase().equals("found")) {
//            out = new String[] { "found", userInput.substring(6).toLowerCase() };
//        } else {
//            out = inputArr;
//        }
//        return out;
//    }
//
//    public synchronized String[] getInput() throws IOException, ParseException {
//        String[] out = new String[0];
//        if(terminal) {
//            String userInput;
//            System.out.print("> ");
//            userInput = in.nextLine();
//            System.out.println();
//
//            //checks if the input is equal to the codeword and sets the output to "start"
//            out = parseInput(userInput);
//
//        } else {
//            InputStream input = socket.getInputStream();
//            InputStreamReader reader = new InputStreamReader(input);
//
//            BufferedReader br = new BufferedReader(reader);
//            String line = "";
//            while ((line = br.readLine()) != null) {    //read line by line
//                JSONObject jsonObject = (JSONObject) parser.parse(line);
//                out = new String[] {"socket", jsonObject.toString()};
//            }
//        }
//        return out;
//    }

    public synchronized void switchTerminaltoSocketInput() { this.inputStream = this.socketIn; }

    public synchronized void switchSockettoTerminalInput() { this.inputStream = this.terminalIn; }

//    private synchronized void setConsoleStatus(boolean status) { this.running = status; }
//
//    private synchronized boolean getConsoleStatus() { return this.running; }

    @Override
    public void run() {
        while(running) {
            notifyObservers(inputStream.getInput(), this);
        }
    }
}

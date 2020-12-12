package com.myProject.Driver.inputStrategies;

import java.util.Scanner;

public class terminalInput implements inputStream {
    private Scanner in;
    public terminalInput(Scanner in) { this.in = in; }

    public String[] parseInput(String userInput) {
        String out[];
        userInput = userInput.toLowerCase();
        //splits the userInput into an array
        String[] inputArr = userInput.split(" ");

        if(inputArr[0].equals("take")) {
            if(inputArr.length < 2) out = new String[] { "take", ""};
            else out = new String[] { "take", inputArr[1] };
        }
        else if(userInput.equals("take")) {
            out = new String[] {"take", ""};
        }
        else if(userInput.equals("mischief managed")) {
            out = new String[] {"stop"};
        }
        //checks if input is equal to the "look around" and sets the output to "look"
        else if(userInput.equals("look around")) {
            out = new String[] {"look"};
        }
        else if(userInput.equals("time")) {
            out = new String[] {"watch"};
        }
        //checks if the first word is "use" and sets the output to "use", "...."
        else if(inputArr[0].equals("use")) {
            if(inputArr.length < 2) out = new String[] { "use", ""};
            else out = new String[] { "use", userInput.substring(4)};
        }
        else if(inputArr[0].equals("make")) {
            if(inputArr.length < 2) out = new String[] { "make", ""};
            else out = new String[] { "make", userInput.substring(5)};
        }
        else if(inputArr[0].equals("inv")) {
            out = new String[] { "inventory" };
        }
        else if(inputArr[0].equals("test")) {
            out = new String[] { "test" };
        }
        //checks if the length is 2 or more, first word is "talk", second is "to" and sets the output to "talk", "...."
        else if(userInput.equals("talk")) {
            out = new String[] { "talk", ""};
        }
        else if(inputArr[0].equals("talk") && inputArr[1].equals("to")) {
            out = new String[] { "talk", inputArr[2] };
        }
        else {
            out = inputArr;
        }
        return out;
    }

    @Override
    public String[] getInput() throws InterruptedException {
        Thread.sleep(100);
        String userInput;
        System.out.println();
        System.out.print("> ");
        userInput = in.nextLine();

        //checks if the input is equal to the codeword and sets the output to "start"
        return parseInput(userInput);
    }
}

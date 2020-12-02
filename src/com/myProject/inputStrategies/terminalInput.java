package com.myProject.inputStrategies;

import java.util.Scanner;

public class terminalInput implements inputStream {
    private Scanner in;
    public terminalInput(Scanner in) { this.in = in; }

    public String[] parseInput(String userInput) {
        String out[];
        //splits the userInput into an array
        String[] inputArr = userInput.split(" ");

        if (userInput.equals(" ")) {
            out = new String[] {"start"};
        }
        //checks if input is equal to the "mischief managed" and sets the output to "stop"
        else if(userInput.toLowerCase().equals("test")) {
            out = new String[] {"test"};
        }
        else if(userInput.toLowerCase().equals("mischief managed")) {
            out = new String[] {"stop"};
        }
        //checks if input is equal to the "look around" and sets the output to "look"
        else if(userInput.toLowerCase().equals("look around")) {
            out = new String[] {"look"};
        }
        else if(userInput.toLowerCase().equals("exit")) {
            out = new String[] {"exit"};
        }
        else if(userInput.toLowerCase().equals("time")) {
            out = new String[] {"watch"};
        }

        //lol idk why this is there i guess for test purposes?? :')
        else if(userInput.toLowerCase().equals("potato")) {
            out = new String[] {"tomato"};
        }

        //checks if the first word is "use" and sets the output to "use", "...."
        else if(inputArr[0].toLowerCase().equals("use")) {
            out = new String[] { "use", userInput.substring(4).toLowerCase()};
        }
        //checks if the length is 2, first word is "walk" and sets the output to "walk", "...."
        else if(inputArr.length == 2 && inputArr[0].toLowerCase().equals("walk")) {
            out = new String[] { "walk", inputArr[1].toLowerCase()};
        }
        else if(userInput.toLowerCase().equals("walk")) {
            out = new String[] {"walk", ""};
        }
        //checks if the length is 2 or more, first word is "talk", second is "to" and sets the output to "talk", "...."
        else if(inputArr.length >= 2 && inputArr[0].toLowerCase().equals("talk") && inputArr[1].toLowerCase().equals("to")) {
            out = new String[] { "talk", userInput.substring(8) };
        }
        else if(inputArr.length == 2 && inputArr[0].toLowerCase().equals("found")) {
            out = new String[] { "found", userInput.substring(6).toLowerCase() };
        } else {
            out = inputArr;
        }
        return out;
    }

    @Override
    public String[] getInput() {
        String userInput;
        System.out.print("> ");
        userInput = in.nextLine();
        System.out.println();

        //checks if the input is equal to the codeword and sets the output to "start"
        return parseInput(userInput);
    }
}

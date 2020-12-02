package com.myProject.inputStrategies;

import com.myProject.Observer.Observer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketInput implements inputStream, Runnable {
    private int port;
    private String host;
    private Socket socket;
    private Thread thread;
    private String[] out;
    private boolean reading;
    private JSONParser parser = new JSONParser();

    public socketInput(String host, int port) {
        this.host = host;
        this.port = port;
        this.thread = new Thread(this);
        this.reading = true;
        this.thread.start();
    }

    @Override
    public synchronized String[] getInput() {
        return this.out;
    }

    @Override
    public void run() {
        String line = "";
        try {
            this.socket = new Socket(host, port);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(reader);
            while ((line = br.readLine()) != null && reading) {
                JSONObject jsonObject = (JSONObject) parser.parse(line);
                out = new String[] {"socket", jsonObject.toString()};
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

package com.myProject.Driver.inputStrategies;

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
        String face;
        String line;
        String heading;
        try {
            this.socket = new Socket(host, port);
            InputStream input = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(reader);
            while ((line = br.readLine()) != null && reading) {
                JSONObject jsonObject = (JSONObject) parser.parse(line);

                String time = (String) jsonObject.get("loggingTime");
                double xAcc = Double.parseDouble((String) jsonObject.get("accelerometerAccelerationX"));
                double yAcc = Double.parseDouble((String) jsonObject.get("accelerometerAccelerationY"));
                double zAcc = Double.parseDouble((String) jsonObject.get("accelerometerAccelerationZ"));
                double mHead = Double.parseDouble((String) jsonObject.get("locationMagneticHeading"));

                out = new String[] {"socket", time, getFace(xAcc, zAcc), getHeading(mHead), getSwinging(xAcc, yAcc)};
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String getSwinging(double xAcc, double yAcc) {
        if(xAcc < -1) return "Retreating";
        else if(yAcc > 2) return "Swinging";
        else return "Stationary";
    }

    private String getHeading(double mHead) {
        if(mHead >= 315 || mHead < 45) return "North";
        else if(mHead >= 45 || mHead < 135) return "East";
        else if(mHead >= 135 || mHead < 225) return "South";
        else return "West";
    }

    private String getFace(double xAcc, double zAcc) {
        if(xAcc < -0.75) return "Left";
        else if(xAcc > 0.75) return "Right";
        else if(zAcc > 0.75) return "Down";
        else return "Up";
    }
}

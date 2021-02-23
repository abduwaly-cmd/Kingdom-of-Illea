package com.myProject.Driver;

import com.myProject.Observer.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client extends ConcreteObserver {
    private int port;
    private String host;
    private Socket socket;
    private boolean connected;
    private static TCP_Client instance;

    TCP_Client(Subject test) {
        super(test);
        connected = false;
        System.out.print("[Socket] Enter IP & Port in the following manner [IP address] [Port number]");
    }

    public boolean isReachable() {
        try {
            this.socket = new Socket();
            this.socket.connect(new InetSocketAddress(this.host, this.port), 1000);
            this.connected = true;
            return true;
        } catch (UnknownHostException e) {
            System.out.println("[Socket] Wrong IP & Address " + e.getMessage());
            e.printStackTrace();
        } catch (IOException ignored) { }
        System.out.print("[Socket] Enter IP & Port Again again.. [IP Port] >");
        return false;
    }

    public static TCP_Client getInstance(Subject test) {
        if (instance == null)
            instance = new TCP_Client(test);
        return instance;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public synchronized boolean isConnected() { return connected; }

    @Override
    public void update(String[] in) {
        if(in.length == 2) {
            this.host = in[0];
            this.port = Integer.parseInt(in[1]);
            System.out.println("[Socket] Establishing connection to " + this.host + ":" + this.port);
            this.isReachable();
        } else {
            System.out.print("[Socket] Invalid Input... [IP Port] >");
        }
    }
}

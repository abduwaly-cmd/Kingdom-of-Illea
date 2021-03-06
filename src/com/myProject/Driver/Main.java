package com.myProject.Driver;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		Console console = new Console();
		TCP_Client TCP_Session = TCP_Client.getInstance(console);
		while(!TCP_Session.isConnected()) { Thread.sleep(10); };
		console.removeObserver(TCP_Session);
		console.setSocket(TCP_Session.getHost(), TCP_Session.getPort());

		Player chrom = Player.getInstance(console, "Chrom");
	}
}

package com.myProject.Main;

import com.myProject.Observer.Subject;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Console console = new Console();

			//	TCP_Client TCP_Session = TCP_Client.getInstance(console);
			//	while(!TCP_Session.isConnected()) { Thread.sleep(10); };
			//	console.removeObserver(TCP_Session);
			//	console.setSocket(TCP_Session.getHost(), TCP_Session.getPort());

		// 192.168.1.101 57617
		console.setSocket("192.168.1.101", 57617);
		Player chrom = Player.getInstance((Subject) console, "Chrom");
	}
}

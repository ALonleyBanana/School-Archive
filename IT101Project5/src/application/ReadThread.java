package application;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Platform;

public class ReadThread implements Runnable {
	//private vars
	Socket skt;
	CliFX cli;
	DataInputStream in;
	//constructor
	public ReadThread(Socket skt, CliFX cli) {
		this.skt=skt;
		this.cli=cli;
	}
	@Override
	public void run() {
		//loop
		while(true) {
			try {
				//DataInputStream
				in = new DataInputStream(skt.getInputStream());
				//input from client
				String msg = in.readUTF();
				//append to ta
				Platform.runLater(() -> {
					cli.taDisplay.appendText(msg + '\n');
				});
			}
			catch (IOException ex) {
				System.out.println("Error Reading from the server: " + ex.getMessage());
				System.out.println("You should not recieve this message");
				ex.printStackTrace();
				break;
			}
		}
	}
}

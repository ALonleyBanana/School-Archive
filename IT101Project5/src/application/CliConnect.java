package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Platform;

public class CliConnect implements Runnable {
	Socket skt;
	ServerFx srv;
	//data streams
	DataInputStream in;
	DataOutputStream out;
	
	//constructor
	public CliConnect(Socket skt, ServerFx srv) {
		this.skt = skt;
		this.srv = srv;
	}
	
	@Override
	public void run() {
		try {
			//new data streams
			in = new DataInputStream(skt.getInputStream());
			out = new DataOutputStream(skt.getOutputStream());
			while(true) {
				//msg retrieval
				String msg = in.readUTF();
				//msg broadcast
				srv.broadcast(msg);
				//append msg to ta
				Platform.runLater(() -> {
					srv.taDisplay.appendText(msg + '\n');
				});
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				skt.close();
				}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
	}
	//send to client
	public void sendMsg(String msg) {
		try {
			out.writeUTF(msg);
			out.flush();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}

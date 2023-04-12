package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ServerFx extends Application {
	//display
	public TextArea taDisplay;
	//list of connections
	public List<CliConnect> cnLst = new ArrayList<CliConnect>();
	
	@Override
	public void start(Stage stg) {
		//display
		taDisplay = new TextArea();
		taDisplay = new TextArea();
		taDisplay.setEditable(false);
		//display pane
		ScrollPane sp = new ScrollPane();
		sp.setContent(taDisplay);
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);
		//scene
		Scene s = new Scene(sp,450,500);
		stg.setTitle("Server"); //title
		stg.setScene(s); 
		stg.show(); //Display Stg
		//threads (Multi user because i felt like implementing it)
		new Thread(() -> {
			try {
				//socket
				ServerSocket sSkt = new ServerSocket(ConnectUtil.port);
				//append msg to TA
				Platform.runLater (() -> taDisplay.appendText("Server Started"));
				//loop
				while (true) {
					//listen and add connections
					Socket skt = sSkt.accept();
					CliConnect c = new CliConnect(skt, this);
					cnLst.add(c);
					//new thread
					Thread t = new Thread(c);
					t.start();
				}
			}
			catch (IOException ex) {
				taDisplay.appendText(ex.toString() + '\n');
			}
		
				}).start();
	}
	public static void main(String[] args) {
		launch(args);
	}
	//I thought this coed was useless but it actually is needed especially for multiclient
	//sends messages
	public void broadcast(String msg) {
		for(CliConnect cCnct :this.cnLst) {
			cCnct.sendMsg(msg);
		}
	}
}

package application;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class CliFX extends Application{
		//controls
		TextField tName;
		TextField tIn;
		ScrollPane sp;
		public TextArea taDisplay;
		
		//IO stream
		DataOutputStream out;
		
		@Override
		public void start(Stage stg) throws Exception {
			VBox vBox = new VBox();
			sp = new ScrollPane();
			HBox hbox = new HBox();
			
			
			taDisplay = new TextArea();
			taDisplay.setEditable(false);
			sp.setContent(taDisplay);
			sp.setFitToHeight(true);
			sp.setFitToWidth(true);
			
			tName = new TextField();
			tName.setPromptText("Name");
			tName.setTooltip(new Tooltip("Name here"));
			tIn = new TextField();
			tIn.setPromptText("Message");
			
			tIn.setOnKeyPressed(new keys());
			hbox.getChildren().addAll(tName,tIn);
			hbox.setHgrow(tIn, Priority.ALWAYS);
			vBox.getChildren().addAll(sp,hbox);
			vBox.setVgrow(sp, Priority.ALWAYS);
			Scene s = new Scene(vBox,450,500);
			stg.setTitle("Chat");
			stg.setScene(s);
			stg.show();
			try {
				Socket sk = new Socket(ConnectUtil.host, ConnectUtil.port);
				taDisplay.appendText("Connected. \n");
				out = new DataOutputStream(sk.getOutputStream());
				ReadThread t = new ReadThread(sk,this);
				Thread tr = new Thread(t);
				tr.start();
			}
			catch (IOException ex) {
				taDisplay.appendText(ex.toString()+ '\n');
			}
		}
		public static void main(String[] args) {
			launch(args);
		}
		private class keys implements EventHandler<KeyEvent> {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode()== KeyCode.ENTER) {
				try {
					String u = tName.getText().trim();
					String m = tIn.getText().trim();
					if(u.length()==0) {
						u = "UNKNOWN USER";
					}
					if(m.length() == 0) {
						return;
					}
					out.writeUTF("[" + u + "]" + m + "");
					out.flush();
				}
				catch(IOException ex) {
					System.err.println(ex);
				}
				
			}
		}
		}
}

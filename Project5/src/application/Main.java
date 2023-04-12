package application;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// a simple JavaFX calculator.
public class Main extends Application {
	 private static final String[][] numMap = {
		      { "7", "8", "9", "/" },
		      { "4", "5", "6", "*" },
		      { "1", "2", "3", "-" },
		      { "0", "0", "^", "+" },
		      { "(", ")","=", "^" },
		  };
	  public static void main(String[] args) { 
		  launch(args);
	   }
	  TextField history = new TextField();
		TextField output = new TextField();
		Stack<Double> a = new Stack<Double>();
		Stack<String> np = new Stack<String>();
		Stack<String> p = new Stack<String>();
		Stack<Double> b = new Stack<Double>();
		boolean par = false;
		boolean op = false;
		String end = "";
		double val = 0;
	@Override
	public void start(Stage stage) throws Exception {
		
		TilePane Buttons = createButtonMap();
		final VBox sc = new VBox(20);
	    sc.setAlignment(Pos.CENTER);
	    sc.setStyle("-fx-background-color: springgreen; -fx-padding: 10; -fx-font-size: 14;");
	    sc.getChildren().setAll(output, history, Buttons);
	    output.prefWidthProperty().bind(Buttons.widthProperty());
	    stage.setTitle("Postfix Calculator");
	    stage.initStyle(StageStyle.UTILITY);
	    stage.setResizable(false);
	    stage.setScene(new Scene(sc));
	    stage.show();
	    
		
	}
	public TilePane createButtonMap() {
		  TilePane butts = new TilePane();
		    butts.setVgap(7);
		    butts.setHgap(7);
		    butts.setPrefColumns(numMap[0].length);
		    for (String[] r: numMap) {
		      for (String s: r) {
		        butts.getChildren().add(makeButt(s));
		      }
		    }
		    return butts;
	}
	public Button makeButt(String s) {
		Button butt = new Button(s);
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	//if(op) {
                if(par) {
                	b.add(Double.parseDouble(s));
                	output.appendText(s);
                }
                if(!par) {
                		a.add(Double.parseDouble(s));
                		output.appendText(s);
                		}
                
            		//}
            	//else {
            		
            	//}
            } 
        }; 
        EventHandler<ActionEvent> submit = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                history.appendText(s);
                history.setText(" ");
                output.appendText(" ");
                while(!np.isEmpty()) {
                	String h= np.pop();
                	Double c = a.pop();
                	Double d = a.pop();
                	Double ans = 0.0;
                	if(h == "(") {
                		String i = "";
                		while(i != ")") {
                			String hp = p.pop();
                			Double pA = b.pop();
                			Double pB = b.pop();
                			if(hp == "*") {
                        		ans = pA*pB;
                        	}
                        	else if(hp == "/"){
                        		ans = pA/pB;
                        	}
                        	else if(hp == "-"){
                        		ans = pA-pB;
                        	}
                        	else if(hp == "+") {
                        		ans = pA+pB;
                        	}
                		}
                	}
                	else if(h == "*") {
                		ans = c*d;
                	}
                	else if(h == "/"){
                		ans = c/d;
                	}
                	else if(h == "-"){
                		ans = c-d;
                	}
                	else if(h == "+") {
                		ans = c+d;
                	}
                	
                	output.setText(Double.toString(ans));
                	history.appendText(Double.toString(c));
                	history.appendText(Double.toString(d));
                	history.appendText(h);
                }
            } 
        }; 
        EventHandler<ActionEvent> PT = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                par=true;
                output.appendText("(");
            } 
        }; 
        EventHandler<ActionEvent> PF = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                par=false;
                output.appendText(")");
            } 
        }; 
        EventHandler<ActionEvent> op = new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		getOperand(s);
        		output.appendText(s);
        	}
        };
        if (s.matches("[0-9]")) {
        butt.setOnAction(event);
        }
        else if(s == "(") {
        	butt.setOnAction(PT);
        }
        else if(s == ")") {
        	butt.setOnAction(PF);
        }
        else if (s == "="){
		butt.setOnAction(submit);
        }
        else if (s== "+" || s=="-" || s=="*" || s=="/" || s== "^") {
        	butt.setOnAction(op);
        }
        return butt;
	}
	public void getOperand(String s) {
		switch(s) {
			case "+": 
				if(par) {
					p.add(s);
				}
				else if(!par) {
					np.add(s);
				}
				break;
			case "-":
				if(par) {
					p.add(s);
				}
				else if(!par) {
					np.add(s);
				}
				break;
			case "*":
				if(par) {
					p.add(s);
				}
				else if(!par) {
					np.add(s);
				}
				break;
			case "/":
				if(par) {
					p.add(s);
				}
				else if(!par) {
					np.add(s);
				}
				break;
		}
	}
}
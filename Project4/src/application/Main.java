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
      { "7", "8", "9", "/"},
      { "4", "5", "6", "*"},
      { "1", "2", "3", "-"},
      { "0", "=", "^", "+"},
      { "(", ")","=", "^" }
  };

  private final Map<String, Button> keyMaps = new HashMap<>();

  private DoubleProperty stackVal = new SimpleDoubleProperty();
  private DoubleProperty val = new SimpleDoubleProperty();
  private StringProperty hist = new SimpleStringProperty();
  private StringProperty oper = new SimpleStringProperty();
  Stack<String> ops = new Stack<String>();
  Stack<Double> storeVal1 = new Stack<Double>(); 
  public String store = " ";
  private enum Op { NOOP, ADD, SUB, MUL, DIV, EX, PAR}

  private Op curOp   = Op.NOOP;
  private Op stackOp = Op.NOOP;
  TextField his = new TextField();
  public static void main(String[] args) { 
	  launch(args);
   }

  @Override 
  public void start(Stage stage) {
    final TextField dis  = makeDis();
    final TilePane  butts = makeButts();
    
    his.setStyle("-fx-background-color: mintcream;");
    his.setAlignment(Pos.CENTER_RIGHT);
    his.setEditable(false);
    stage.setTitle("Postfix Calculator");
    stage.initStyle(StageStyle.UTILITY);
    stage.setResizable(false);
    stage.setScene(new Scene(makeCalc(dis, his, butts)));
    stage.show();
  }
  //create the calculator
  private VBox makeCalc(TextField dis, TextField his, TilePane butts) {
    final VBox sc = new VBox(20);
    sc.setAlignment(Pos.CENTER);
    sc.setStyle("-fx-background-color: springgreen; -fx-padding: 10; -fx-font-size: 14;");
    sc.getChildren().setAll(dis, his, butts);
    handleKeyMaps(sc);
    dis.prefWidthProperty().bind(butts.widthProperty());
    return sc;
  }

  //Handle the buttons and presses
  private void handleKeyMaps(VBox dis) {
    dis.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent k) {
        Button activated = keyMaps.get(k.getText());
        if (activated != null) {
          activated.fire();
        }
      }
    });
  }
  
  //Create the Display for output and input
  private TextField makeDis() {
    final TextField dis = new TextField();
    dis.setStyle("-fx-background-color: mintcream;");
    dis.setAlignment(Pos.CENTER_RIGHT);
    dis.setEditable(false);
    dis.textProperty().bind(Bindings.format("%.0f", val));
    return dis;
  }

  //create a button tile
  private TilePane makeButts() {
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
 //individual button creation
  private Button makeButt(final String s) {
	  //standard button
    Button butt = makeSButt(s);
    // numeric check
    if (s.matches("[0-9]")) {
      makeNButt(s, butt);
    } 
    else {
      //opperand check
      final ObjectProperty<Op> triggerOp = determineOperand(s);
      if (triggerOp.get() != Op.NOOP) {
        makeOButt(butt, triggerOp);
      } 
      else if ("=".equals(s)) {
        makeEButt(butt);
      }
    }

    return butt;
  }
//operand determination
  private ObjectProperty<Op> determineOperand(String s) {
    final ObjectProperty<Op> triggerOp = new SimpleObjectProperty<>(Op.NOOP);
    switch (s) {
      case "+": 
    	  triggerOp.set(Op.ADD);
    	  break;
      case "-":
    	  triggerOp.set(Op.SUB);
    	  break;
      case "*":
    	  triggerOp.set(Op.MUL);
    	  break;
      case "/":
    	  triggerOp.set(Op.DIV);
    	  break;
      case "^":
    	  triggerOp.set(Op.EX);
    	  break;
      case ")":
    	  triggerOp.set(Op.NOOP);
    	  break;
      case "(":
    	  triggerOp.set(Op.PAR);
    	  break;
    }
    return triggerOp;
  }
//operator buttons
  private void makeOButt(Button butt, final ObjectProperty<Op> triggerOp) {
    butt.setStyle("-fx-base: tan;");
    butt.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        curOp = triggerOp.get();
        switch(curOp) { 
        	case ADD: 
        		ops.add("+");
        		break;
		case DIV:
			ops.add("/");
			break;
		case EX:
			ops.add("^");
			break;
		case MUL:
			ops.add("*");
			break;
		case SUB:
			ops.add("-");
			break;
		case PAR:
			ops.add("-");
			break;
			
		
		
        }
      }
    });
  }
//standard button
  private Button makeSButt(String s) {
    Button butt = new Button(s);
    butt.setStyle("-fx-base: snow;");
    keyMaps.put(s, butt);
    butt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    return butt;
  }

  private void makeNButt(final String s, Button butt) {
    butt.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        if (curOp == Op.NOOP) {
          val.set(val.get() * 10 + Integer.parseInt(s));
          
        } 
        else {
          stackVal.set(val.get());
          val.set(Integer.parseInt(s));
          his.appendText(s);
          
          stackOp = curOp;
          curOp = Op.NOOP;
        }
      }
    });
  }


  private void makeEButt(Button butt) {
    butt.setStyle("-fx-base: aqua;");
    butt.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        switch (stackOp) {
          case ADD:      
        	  val.set(stackVal.get() + val.get());
        	  
        	  break;
          case SUB:
        	  val.set(stackVal.get() - val.get());
        	  
        	  break;
          case MUL:
        	  val.set(stackVal.get() * val.get());
        	
        	  break;
          case DIV:
        	 
        	  val.set(stackVal.get() / val.get());
        	  
        	  break;
          case EX:
        	  double num = stackVal.get();
        	  double ex = val.get();
        	  double h = 1;
        	  for (int i=0; i<ex; i++) {
        		  h=h*num;
        	  }
        	  val.set(h);
        	
        	  break;
        }
      }
    });
  }
}
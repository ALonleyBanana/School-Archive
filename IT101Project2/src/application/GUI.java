package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class GUI extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Order Form");
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(50,50,50,50));
		
		Scene scene = new Scene(grid,1500,800);
		primaryStage.setScene(scene);
		
		Text title = new Text("Fill out the forum below");
		
		grid.add(title, 0, 0,2,1);
		
		Label Fname = new Label("First Name: ");
		TextField FnameTF = new TextField();
		grid.add(Fname, 0, 1);
		grid.add(FnameTF, 1, 1);
		
		Label Lname = new Label("Last Name: ");
		TextField LnameTF = new TextField();
		grid.add(Lname, 2, 1);
		grid.add(LnameTF, 3, 1);
		Label Add = new Label ("Address: ");
		TextField AddTF = new TextField();
		grid.add(Add, 0, 2);
		grid.add(AddTF, 1, 2);
		Label Phone = new Label("Phone Number: ");
		TextField PhoneTF = new TextField();
		grid.add(Phone, 0, 3);
		grid.add(PhoneTF, 1, 3);
		
		
		
		CheckBox lPizza = new CheckBox("Large Pizza $14.00");
		Label numLlb = new Label ("#: ");
		TextField numLtf = new TextField();
		grid.add(numLlb, 1, 6);
		grid.add(numLtf, 2, 6);
		Label lprice = new Label("Toppings (+$3.00 per topping)");
		Label Inst = new Label("Max of 4 toppings");
		grid.add(lPizza, 0, 6);
		grid.add(lprice, 1, 7);
		grid.add(Inst,2,7);
		
		CheckBox lPep = new CheckBox("Pepperoni");
		Label numLPep = new Label ("Pepperoni #: "); 
		TextField numLPept = new TextField("0");
		grid.add(lPep, 1, 8);
		grid.add(numLPep, 1, 9);
		grid.add(numLPept, 2, 9);
		
		CheckBox lS = new CheckBox("Sausage");
		Label numLS = new Label ("Sausage #: "); 
		TextField numLSt = new TextField("0");
		grid.add(lS, 2, 8);
		grid.add(numLS, 3, 9);
		grid.add(numLSt, 4, 9);
		
		CheckBox lMB = new CheckBox("MeatBall");
		Label numLMB = new Label ("MeatBall #: "); 
		TextField numLMBt = new TextField("0");
		grid.add(lMB, 3, 8);
		grid.add(numLMB, 5, 9);
		grid.add(numLMBt, 6, 9);
		
		CheckBox lM = new CheckBox("Mushroom");
		Label numLM = new Label ("Mushroom #: "); 
		TextField numLMt = new TextField("0");
		grid.add(lM, 4, 8);
		grid.add(numLM, 1, 10);
		grid.add(numLMt, 2, 10);
		
		CheckBox lO = new CheckBox("Onions");
		Label numLO = new Label ("Onion #: "); 
		TextField numLOt = new TextField("0");
		grid.add(lO, 5, 8);
		grid.add(numLO, 3, 10);
		grid.add(numLOt, 4, 10);
		
		CheckBox lP = new CheckBox("Peppers");
		Label numLP = new Label ("Peppers #: "); 
		TextField numLPt = new TextField("0");
		grid.add(lP, 6, 8);
		grid.add(numLP, 5, 10);
		grid.add(numLPt, 6, 10);
		
		CheckBox lC = new CheckBox("Extra Cheese");
		Label numLC = new Label ("Cheese #: "); 
		TextField numLCt = new TextField("0");
		grid.add(lC, 7, 8);
		grid.add(numLC, 7, 10);
		grid.add(numLCt, 8, 10);
		
		CheckBox sPizza = new CheckBox("Small Pizza $11.25");
		Label numSlb = new Label ("#: ");
		TextField numStf = new TextField();
		grid.add(numSlb, 1, 11);
		grid.add(numStf, 2, 11);
		grid.add(sPizza, 0, 11);
		Label sprice = new Label("Toppings (+$2.00 per topping)");
		Label SInst = new Label("Max of 4 toppings ");
		//grid.add(sPizza, 0, 12);
		grid.add(sprice, 1, 12);
		grid.add(SInst,2,12);
		
		CheckBox sPep = new CheckBox("Pepperoni ");
		Label numSPep = new Label ("Pepperoni #: "); 
		TextField numSPept = new TextField("0");
		grid.add(sPep, 1, 13);
		grid.add(numSPep, 1, 14);
		grid.add(numSPept, 2, 14);
		
		CheckBox sS = new CheckBox("Sausage ");
		Label numSS = new Label ("Sausage #: "); 
		TextField numSSt = new TextField("0");
		grid.add(sS, 2, 13);
		grid.add(numSS, 3, 14);
		grid.add(numSSt, 4, 14);
		
		CheckBox sMB = new CheckBox("MeatBalls");
		Label numSMB = new Label ("MeatBall #: "); 
		TextField numSMBt = new TextField("0");
		grid.add(sMB, 3, 13);
		grid.add(numSMB, 5, 14);
		grid.add(numSMBt, 6, 14);
		
		CheckBox sM = new CheckBox("Mushrooms");
		Label numSM = new Label ("Mushroom #: "); 
		TextField numSMt = new TextField("0");
		grid.add(sM, 4, 13);
		grid.add(numSM, 1, 15);
		grid.add(numSMt, 2, 15);
		
		CheckBox sO = new CheckBox("Onions ");
		Label numSO = new Label ("Onion #: "); 
		TextField numSOt = new TextField("0");
		grid.add(sO, 5, 13);
		grid.add(numSO, 3, 15);
		grid.add(numSOt, 4, 15);
		
		CheckBox sP = new CheckBox("Peppers ");
		Label numSP = new Label ("Peppers #: "); 
		TextField numSPt = new TextField("0");
		grid.add(sP, 6, 13);
		grid.add(numSP, 5, 15);
		grid.add(numSPt, 6, 15);
		
		CheckBox sC = new CheckBox("Extra Cheese ");
		Label numSC = new Label ("Cheese #: "); 
		TextField numSCt = new TextField("0");
		grid.add(sC, 7, 13);
		grid.add(numSC, 7, 15);
		grid.add(numSCt, 8, 15);
		
		
		
		CheckBox siPizza = new CheckBox("Sicilian Pizza $18.00");
		Label numSilb = new Label ("#: ");
		TextField numSitf = new TextField();
		grid.add(numSilb, 1, 16);
		grid.add(numSitf, 2, 16);
		grid.add(siPizza, 0, 16);
		
		CheckBox calzone = new CheckBox("Calzone $7.75");
		Label numClb = new Label ("#: ");
		TextField numCtf = new TextField();
		grid.add(calzone, 0, 17);
		grid.add(numClb, 1, 17);
		grid.add(numCtf, 2, 17);
		CheckBox gk = new CheckBox("Garlic Knots $3.50");
		grid.add(gk, 0, 18);
		Label numGlb = new Label ("#: ");
		TextField numGtf = new TextField();
		grid.add(numGlb, 1, 18);
		grid.add(numGtf, 2, 18);
		CheckBox bz = new CheckBox("Baked Ziti $11.00");
		Label numBlb = new Label ("#: ");
		TextField numBtf = new TextField();
		grid.add(numBlb, 1, 19);
		grid.add(numBtf, 2, 19);
		CheckBox ap = new CheckBox("AntiPasto $12.50");
		Label numAlb = new Label ("#: ");
		TextField numAtf = new TextField();
		grid.add(numAlb, 1, 20);
		grid.add(numAtf, 2, 20);
		
		grid.add(bz, 0, 19);
		grid.add(ap, 0, 20);
		
		
		Button submitBtn = new Button("Submit Order");
		HBox submitHB = new HBox(10);
		submitHB.setAlignment(Pos.BOTTOM_RIGHT);
		submitHB.getChildren().add(submitBtn);
		grid.add(submitHB, 1, 21);
		final Text nameAT = new Text();
		grid.add(nameAT,1,23);
		final Text PhoneAT = new Text();
		grid.add(PhoneAT, 2, 23);
		final Text BillAT = new Text();
		grid.add(BillAT, 1, 24);
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			 
		    @Override
		    public void handle(ActionEvent e) {
		    	double a = 0;
		    	if(lPizza.isSelected() == true) {
		    		int fin = Integer.parseInt(numLtf.getText());
		    		int P = Integer.parseInt(numLPept.getText());
		    		int S = Integer.parseInt(numLSt.getText());
		    		int MB = Integer.parseInt(numLMBt.getText());
		    		int M = Integer.parseInt(numLMt.getText());
		    		int O = Integer.parseInt(numLOt.getText());
		    		int Pe = Integer.parseInt(numLPt.getText());
		    		int C = Integer.parseInt(numLCt.getText());
		    		if(lMB.isSelected()) {
		    			a = a+(3*MB);
		    		}
		    		if(lS.isSelected()) {
		    			a = a+(3*S);
		    		}
		    		if(lP.isSelected()) {
		    			a = a+(3*Pe);
		    		}
		    		if(lPep.isSelected()) {
		    			a=a+(3*P);
		    			
		    		}
		    		if(lM.isSelected()) {
		    			a=a+(3*M);
		    		}
		    		if(lO.isSelected()) {
		    			a=a+(3*O);
		    		}
		    		if(lC.isSelected()) {
		    			a=a+(3*C);
		    		}
		    		a=a+(fin*14);
		    	}
		    	if(sPizza.isSelected()==true) {
		    		int fin = Integer.parseInt(numStf.getText());
		    		int P = Integer.parseInt(numSPept.getText());
		    		int S = Integer.parseInt(numSSt.getText());
		    		int MB = Integer.parseInt(numSMBt.getText());
		    		int M = Integer.parseInt(numSMt.getText());
		    		int O = Integer.parseInt(numSOt.getText());
		    		int Pe = Integer.parseInt(numSPt.getText());
		    		int C = Integer.parseInt(numSCt.getText());
		    		if(sMB.isSelected()) {
		    			a = a+(3*MB);
		    		}
		    		if(sS.isSelected()) {
		    			a = a+(3*S);
		    		}
		    		if(sP.isSelected()) {
		    			a = a+(3*Pe);
		    		}
		    		if(sPep.isSelected()) {
		    			a=a+(3*P);
		    			
		    		}
		    		if(sM.isSelected()) {
		    			a=a+(3*M);
		    		}
		    		if(sO.isSelected()) {
		    			a=a+(3*O);
		    		}
		    		if(sC.isSelected()) {
		    			a=a+(3*C);
		    		}		    		
		    		a=a+(fin*14);
		    	}
		    	if(siPizza.isSelected()==true) {
		    		int fin = Integer.parseInt(numSitf.getText());
		    		a=a+(18*fin);
		    	}
		    	if(calzone.isSelected()==true) {
		    		int fin = Integer.parseInt(numCtf.getText());
		    		a=a+(7.75*fin);
		    	}
		    	if(gk.isSelected()==true) {
		    		int fin = Integer.parseInt(numGtf.getText());
		    		a=a+(3.5*fin);
		    	}
		    	if(bz.isSelected()==true) {
		    		int fin = Integer.parseInt(numBtf.getText());
		    		a=a+(11*fin);
		    	}
		    	if(ap.isSelected()==true) {
		    		int fin = Integer.parseInt(numAtf.getText());
		    		a=a+(12.5*fin);
		    	}
		    	
		        nameAT.setText(FnameTF.getText() + " " + LnameTF.getText()+ " at " + AddTF.getText());
		        PhoneAT.setText(PhoneTF.getText() );
		        BillAT.setText("Total: $" + a);
		    }
		});
		primaryStage.show();
	
		
	}
	public static void main (String[] args) {
		launch(args);
	}
}

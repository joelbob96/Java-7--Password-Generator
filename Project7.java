import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;;
import javafx.stage.Stage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.layout.FlowPane;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.event.*;
import javafx.geometry.*;


 
 public class Project7 extends Application{
 
 private Label lbl;
 private Button passbtn;
 private RadioButton radio8;
 private RadioButton radio16;
 private RadioButton radio32;
 ToggleGroup tg;
 private CheckBox caps;
 private CheckBox spChar;
 private CheckBox nums;
 private int length = 8;
 private String alphabet = "abcdefghijklmnopqrstuvwxyz";
 int N = alphabet.length();
 boolean capsselected = false;
 boolean spCharselected = false;
 boolean numsselected = false;
 
 public static void main(String[] args) {
        launch(args);
    }
	
	
	public void start(Stage myStage){
		
		myStage.setTitle("Project 7:Password Creator");
		FlowPane root = new FlowPane( Orientation.VERTICAL, 0, 10 );
		root.setPadding(new Insets(10, 10, 10, 10));
		Scene myScene = new Scene( root, 300, 250 );
		myStage.setScene( myScene );
		lbl = new Label("Password Creator");
		lbl.setStyle("-fx-border-color: black;");
		
		passbtn = new Button("Create Password");
		radio8 = new RadioButton("8");
		radio8.setSelected(true);
		radio16 = new RadioButton("16");
		radio32 = new RadioButton("32");
		caps = new CheckBox("Use Caps");
		spChar = new CheckBox("Use Special Characters");
		nums = new CheckBox("Use numbers");
		
		tg = new ToggleGroup();
		radio8.setToggleGroup( tg );
		radio16.setToggleGroup( tg );
		radio32.setToggleGroup( tg );
		
		passbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				
				if(caps.isSelected()){
					alphabet = alphabet + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				}
				
				if(spChar.isSelected()){
					alphabet = alphabet + "!@#%&";
				}
				
				if(nums.isSelected()){
					alphabet = alphabet + "0123456789";
				}
				
				N = alphabet.length();
				String s = "";
				Random r = new Random();
				for(int i = 0;i < length;i++){
					s = s + alphabet.charAt(r.nextInt(N));
				}
				lbl.setText(s);
				alphabet = "abcdefghijklmnopqrstuvwxyz";
			}
		});
		
		radio8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				length = 8;
			}
		});
		
		radio16.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				length = 16;
			}
		});
		
		
		
		radio32.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				length = 32;
				
			}
		});
		
		root.getChildren().addAll(
		lbl,
		passbtn,
		radio8,
		radio16,
		radio32,
		caps,
		spChar,
		nums
		);
        
        myStage.show();
 }
 
 }
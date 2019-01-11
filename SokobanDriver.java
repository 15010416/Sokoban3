package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class SokobanDriver extends Application {
	
public void start(Stage stage) throws IOException {
		

	try {
		Parent root = FXMLLoader.load(getClass().getResource("TEST.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Sokoban!!!!");
		stage.setScene(scene);
		stage.show();
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
		
		}
	
	public static void main(String[] args) {
		
		launch(args);
		
		File textFile = new File("level/level1.txt");

		if(textFile.exists()){
			System.out.println("Found the file.");
		}else{
			System.out.println("Cannot find the file.");
		}
		

		FileReader reader = null;
		BufferedReader inputBuffer = null;

		try {
			reader = new FileReader(textFile);
			inputBuffer = new BufferedReader(reader);
			String inputLine = inputBuffer.readLine();
			
			while ((inputLine = inputBuffer.readLine()) != null)  {
				
			System.out.println(inputLine); }
			
		} catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();

		} catch (IOException ioe){
			ioe.printStackTrace();

		} finally {
			if(inputBuffer != null){
				try {
					inputBuffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		
	}
		

		
	}
			
		
	



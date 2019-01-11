package application;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.html.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Level {

	//Holds level information imported from text file
		private ArrayList<String> mapData;
		//Holds level objects once they have been translated & instantiated
		private ArrayList<MapElement> mapObjects;
		//Holds Images of level objects to be displayed
		private ArrayList<ImageView> mapImages;
		//Player character
		private WarehouseKeeper player;
		//Holds all instances of Wall objects
		private ArrayList<Wall> wallBlocks;
		//Holds all instances of Tile objects
		private ArrayList<Tile> floorTiles;
		//Holds all instances of Diamond objects
		private ArrayList<Diamond> diamondTiles;
		//Holds all instances of Crate objects
		private ArrayList<Crate> crates;
		//Tracks number of valid moves the player has made
		private int numberOfMoves;
		//How many objects wide the level is
		private int levelWidth;
		//How many objects tall the level is
		private int levelHeight;
		//Holds image file for Crate objects when they are not on a diamond tile
		private Image crate;
		//Holds image file for Crate objects when they are on a diamond tile
		private Image crateInPlace;
		//Holds image file for Diamond objects
		private Image diamond;
		//Holds image file for Tile objects
		private Image floor;
		//Holds image file for Wall objects
		private Image wall;
		//Holds image file for the WarehouseKeeper object
		private Image sokoban;
		//Freezes game logic once a level has been completed
		private boolean gameRunning;
		//Determines header height within the JavaFX window
		private int headerBuffer = 25;
	    
	    public Level(){
	    	
	    	//Constructor - set default values for all variables
	    	mapData = new ArrayList<String>();
	    	mapObjects = new ArrayList<>();
	    	mapImages = new ArrayList<>();
	    	wallBlocks = new ArrayList<>();
	    	floorTiles = new ArrayList<>();
	    	diamondTiles = new ArrayList<>();
	    	crates = new ArrayList<>();
	    	numberOfMoves = 0;
	    	levelWidth = 0;
	    	levelHeight = 0;
	        crate = new Image("images/Crate.png");
	        crateInPlace = new Image("images/CrateInPlace.png");
	        diamond = new Image("images/Diamond_Edit.png");
	        floor = new Image("images/Floor.png");
	        wall = new Image("images/Wall.png");
	        sokoban = new Image("images/WarehouseKeeper.png");
	        gameRunning = true;
	    }
		
		//Import map information from text file
	 	protected void importLevel(int levelNumber) {
			
	 		/*
	 		 * fileScanner searches for text file within the level folder.
	 		 * If a file is found the scanner will parse through the file &
	 		 * print each line into the mapData ArrayList.
	 		 * 
	 		 * Once the import is complete the levelWidth & levelHeight variables are set
	 		 */
			Scanner fileScanner;
			try {
				fileScanner = new Scanner(new FileReader("level/level"+levelNumber+".txt"));
				while (fileScanner.hasNext()){
					mapData.add(fileScanner.nextLine());
				} for(String str:mapData)
					System.out.println(str);
				fileScanner.close();
				} catch (FileNotFoundException e) {
					System.out.println("Sorry! Unable to find file 'level/level"+levelNumber+".txt'");
					System.out.println("Exiting Application...");
					Runtime.getRuntime().exit(0);
					
					}
			levelWidth = mapData.get(0).length();
			levelHeight = mapData.size();
			}
	 	
	 	//Translates the imported map information into objects
		
	 	protected void decode() {
	 		
	 		/* 'for' loops parse through each character stored in the mapData ArrayList
	 		 * and run each character through a switch case to generate an object.
	 		 * Objects (except the WarehouseKeeper) are added to ArrayLists for 
	 		 * each object type and then all objects are added to the mapObjects
	 		 * ArrayList with movable objects being imported last. 
	 		 */
	 		int x = 0;
	 		int y = 0;
	 		
	 		
	 		/* As each element stored in the mapData ArrayList is a full text string and not a single character,
	 		 * two 'for' loops (one nested inside the other) are used to parse through all the data.
	 		 * The first loop tells the application which element of the ArrayList to look at and the 
	 		 * second loop tells the application which character within the String to look at.
	 		 * 
	 		 */
	 		for (int height=0; height<levelHeight; height++) {
	        	
	 			gridRow=height;
	        	
	        	for (int width=0; width<levelWidth; width++) {
	        		
	        		gridColumn=width;
	        		
	        		char key = mapData.get(height).charAt(width);
	        		
	        		switch (key) {

	                case 'X':
	                	Wall wallInstance = new Wall();
	                    wallBlocks.add(wallInstance);
	                    break;
	                    
	                case '*':
	                	Crate crateInstance = new Crate();
	                    crates.add(crateInstance);
	                    crateInstance.createElement(x, y);
	                    break;

	                case '.':
	                	Diamond diamondInstance = new Diamond();
	                    diamondTiles.add(diamondInstance);
	                    break;

	                case '@':
	                	player = new WarehouseKeeper();
	                    break;

	                case ' ':
	                	Tile tileInstance = new Tile();
	                	floorTiles.add(tileInstance);
	                    break;

	                default:
	                	System.out.println("Unknown symbol detected! Please review level file.");
	                	System.out.println("Exiting Application...");
	    				Runtime.getRuntime().exit(0);
	                    break;
	                    
	                    
	}
		
	}
	        	
	        	mapObjects.addAll(wallBlocks);
	  		  mapObjects.addAll(floorTiles);
	  		  mapObjects.addAll(diamondTiles);
	  		  mapObjects.addAll(crates);
	  		  mapObjects.add(player);
	  		  loadMap();
	
	
	
	
	 		}
		
	 	}
	 	
	 	private void loadMap() {
			
			for(int i = 0; i<mapObjects.size(); i++) {
				
				MapElement tile = mapObjects.get(i);
				
				if(mapImages.size()<0) {
					
					mapImages.clear();
					}
				if (tile instanceof WarehouseKeeper) {
					
					mapImages.add(new ImageView(sokoban));
					mapImages.get(i).setX(mapObjects.get(i).getX()*32);
					mapImages.get(i).setY(mapObjects.get(i).getY()*32+headerBuffer);
					
				} else if(tile instanceof Wall) {
					
					mapImages.add(new ImageView(wall));
					mapImages.get(i).setX(mapObjects.get(i).getX()*32);
					mapImages.get(i).setY(mapObjects.get(i).getY()*32+headerBuffer);
					
				} else if(tile instanceof Tile) {
					
					mapImages.add(new ImageView(floor));
					mapImages.get(i).setX(mapObjects.get(i).getX()*32);
					mapImages.get(i).setY(mapObjects.get(i).getY()*32+headerBuffer);
					
				} else if(tile instanceof Diamond) {
					
					mapImages.add(new ImageView(diamond));
					mapImages.get(i).setX(mapObjects.get(i).getX()*32);
					mapImages.get(i).setY(mapObjects.get(i).getY()*32+headerBuffer);
					
				} else if(tile instanceof Crate) {
					
					mapImages.add(new ImageView(crate));
					mapImages.get(i).setImage(crateCheck(tile));
					mapImages.get(i).setX(mapObjects.get(i).getX()*32);
					mapImages.get(i).setY(mapObjects.get(i).getY()*32+headerBuffer);
					}
				}
			}
}


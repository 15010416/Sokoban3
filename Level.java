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
	    
	    public Level(){
	    	
	   
	 	protected void importLevel(int levelNumber) {
			
	 		
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
	 	
	
		
	 	protected void decode() {
	 
	 		 */
	 		int x = 0;
	 		int y = 0;
	 		
	 		
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


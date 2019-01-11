package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Coordinate {

	private int xCoord;
	private int yCoord;
	
	public Coordinate(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public Coordinate() {
		
	}
	
	public void setXCoord(int x) 
	{	
		xCoord = x;
	}
	
	public void setYCoord(int y) 
	{	
		yCoord = y;
	}
	
	public int getXCoord()
	{
		return this.xCoord;		
	}
	
	public int getYCoord()
	{
		return this.yCoord;
	}
}

package application;

import javafx.scene.image.Image;

public class Tile extends MapElement {
	
	private static Object yCoord;
	private static Object grid;

	public Tile () {
		
		Object xCoord;
		super(xCoord, yCoord, new Image("images/Floor.png"), "Tile", grid);
		setTileYCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("Images/Floor.png", 100, 100, false, false));
		setTileYCoord("Tile");
	}

	private void setTileImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	private void setTileYCoord(Object yCoord2) {
		// TODO Auto-generated method stub
		
	}

}

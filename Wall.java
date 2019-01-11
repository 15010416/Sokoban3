package application;

import javafx.scene.image.Image;

public class Wall extends MapElement {
	
	private static Object yCoord;
	private static Object grid;

	public Wall () {
		
		Object xCoord;
		super(xCoord, yCoord, new Image("images/Wall.png"), "Wall", grid);
		setTileYCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("Images/Wall.png", 100, 100, false, false));
		setTileYCoord("Wall");
	}

	private void setTileImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	private void setTileYCoord(Object yCoord2) {
		// TODO Auto-generated method stub
		
	}

}

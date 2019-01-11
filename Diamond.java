package application;

import javafx.scene.image.Image;

public class Diamond extends MapElement {
	
	private static Object yCoord;
	private static Object grid;

	public Diamond () {
		
		Object xCoord;
		super(xCoord, yCoord, new Image("images/Diamond.png"), "Diamond", grid);
		setTileYCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("Images/Diamond.png", 100, 100, false, false));
		setTileYCoord("Diamond");
	}

	private void setTileImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	private void setTileYCoord(Object yCoord2) {
		// TODO Auto-generated method stub
		
	}

}


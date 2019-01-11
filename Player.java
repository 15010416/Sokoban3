package application;

import javafx.scene.image.Image;

public class Player extends MoveableMapElement {
	
	private static Object yCoord;
	private static Object grid;

	public Player () {
		
		Object xCoord;
		super(xCoord, yCoord, new Image("images/WarehouseKeeper.png"), "Player", grid);
		setTileYCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("Images/WarehouseKeeper.png", 100, 100, false, false));
		setTileYCoord("Player");
	}

	private void setTileImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	private void setTileYCoord(Object yCoord2) {
		// TODO Auto-generated method stub
		
	}

}

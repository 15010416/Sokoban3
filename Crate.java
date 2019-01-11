package application;

import javafx.scene.image.Image;

public class Crate extends MoveableMapElement {
	
	private static Object yCoord;
	private static Object grid;
	Coordinate crateCord = new Coordinate();
	

	public Crate () {
		
		Object xCoord;
		super(xCoord, yCoord, new Image("images/Crate.png"), "Crate", grid);
		setTileXCoord(xCoord);
		setTileYCoord(yCoord);		
		setTileImage(new Image("Images/Crate.png", 100, 100, false, false));
		setTileYCoord("Crate");
		
	}
	
	public void createElement(int x, int y) {
		
		crateCord.setXCoord(x);
		crateCord.setYCoord(y);
		
	}


	private void setTileImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	private void setTileYCoord(Object yCoord2) {
		// TODO Auto-generated method stub
		
	}

}

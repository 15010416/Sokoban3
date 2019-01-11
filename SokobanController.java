package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SokobanController {

    @FXML
    private Button reset;

    @FXML
    private Button next;

    @FXML
    private Button previous;

    @FXML
    private TextField currentlevel;

    @FXML
    private TextField numberofmoves;

    @FXML
    private GridPane levelgrid;

    @FXML
    void nextlevel(ActionEvent event) {

    }

    @FXML
    void previouslevel(ActionEvent event) {

    }

    @FXML
    void resetlevel(ActionEvent event) {

    }

    @FXML
    void showcurrentlevel(ActionEvent event) {

    }

    @FXML
    void shownoofmoves(ActionEvent event) {

    }
    
 
 public void start(Stage primaryStage) {

 
	 GridPane gridpane = new GridPane();
	 gridpane.setPadding(new Insets(5));
	 gridpane.setHgap(10);
	 gridpane.setVgap(10);
	 
	 
	 Crate crate = new Crate();
	 crate.setxCoord(3);
	 crate.setyCoord(5);
	 
	 
	 
	}
 
}


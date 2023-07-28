import javafx.application.*;
import javafx.geometry.Insets;
import intro143.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class main extends Application{
	@Override
	public void start(Stage primaryStage) {
		HBox pane = new HBox();
		Grid temp = new Grid();
		
		temp.setGrid();
		pane.getChildren().add(temp);
		Grid temp1 = new Grid();
		temp.setGrid();
		pane.getChildren().add(temp1);
		Grid temp2 = new Grid();
		temp.setGrid();
		pane.getChildren().add(temp2);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args);
	}

}

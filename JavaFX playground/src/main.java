
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class main extends Application{
	@Override
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("ok"));
		Scene scene = new Scene(pane,200,250);
		primaryStage.setTitle("Stage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Application.launch(args);
	}

}

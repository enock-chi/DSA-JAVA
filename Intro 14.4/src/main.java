import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import intro144.Txt;
import javafx.scene.paint.*;

public class main extends Application{
	public void start(Stage primaryStage) {
		HBox pane = new HBox();
		pane.setPadding(new Insets(10,10,10,10));
		Color[] arr = {Color.BLACK, Color.GREY,Color.AZURE, Color.DARKORCHID,Color.BLUEVIOLET};
		
		for (int k = 0; k < 5; k++) {
			Txt txt = new Txt();
			txt.setColor(arr[k]);
		    pane.getChildren().add(txt);
		}
		
		
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Vert Images");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args);
	}

}


import javafx.application.*;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.math.*;

public class main extends Application{
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setVgap(5);
		pane.setHgap(5);
		
		setPane(pane);
		
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Tic Tac Toe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        launch(args);
	}
	
	public Circle getCircle() {
		Circle circle = new Circle(0,0,20);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		circle.setStrokeWidth(5);
		
		
		return circle;
	}
	
	public StackPane getX() {
		StackPane pane = new StackPane();
		Line line = new Line(0,0,pane.getWidth(),pane.getHeight());
		line.endXProperty().bind(pane.widthProperty().subtract(10));
		line.endYProperty().bind(pane.heightProperty().subtract(10));
		line.setStrokeWidth(5);
		pane.getChildren().add(line);
		Line line1 = new Line(pane.getWidth(),0,0,pane.getHeight());
		line1.endXProperty().bind(pane.widthProperty().subtract(10));
		line1.endYProperty().bind(pane.heightProperty().subtract(10));
		line1.setStrokeWidth(5);
		pane.getChildren().add(line1);
		return pane;
	}
	
	public void setPane(GridPane pane) {
		for ( int i = 0; i < 3 ; i++) {
			for (int x = 0; x < 3 ; x++) {
				int dom = (int)Math.round(Math.random());
				Circle circle = getCircle();
				StackPane X = getX();
				if ( dom == 0) {
					pane.add(X,i,x);
				} else {
					pane.add(circle, i, x);
				}
				
			}
		}
	}

}

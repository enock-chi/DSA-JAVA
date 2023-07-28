package intro143;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.math.*;

public class Circ {
	private Pane pane = new Pane();
	private Circle circle = new Circle(0,0,10);
	
	
	public Circ() {
		int dom = (int)(Math.round(Math.random()));
		circle.setStroke(null);
		if (dom == 0) {
			circle.setFill(Color.WHITE);
		} else {
			circle.setFill(Color.RED);
		}
		pane.getChildren().add(circle);
	}
	
	public Pane getPane() {
		return pane;
	}

}

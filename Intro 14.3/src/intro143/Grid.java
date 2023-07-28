package intro143;
import intro143.Circ;
import java.util.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Grid extends GridPane{
	
	public Grid() {
		setStyle("-fx-background-color: black;");
		setGrid();
		setPadding(new Insets(20,20,20,20));
	}
	
	
	public void setGrid() {
		 for (int k = 0; k < 2 ; k++) {
			 for (int x = 0; x < 6; x++) {
				 Random random = new Random();
				 int dom = random.nextInt(4);
				 if ( dom == 0) {
					 add(new Circ().getPane(), k, x);
				 } else {
					 Circle blackCirc = new Circle(0,0,10);
					 blackCirc.setFill(Color.BLACK);
					 blackCirc.setStroke(null);
				 }
			 }
		 }
		
	}

}

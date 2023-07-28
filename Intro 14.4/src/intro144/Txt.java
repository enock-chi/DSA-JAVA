package intro144;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.transform.Rotate;
import javafx.geometry.*;
import javafx.scene.paint.*;

public class Txt extends VBox{
	private Text text = new Text("Java FX");
	
	public Txt() {
		//setPadding(new Insets(0,0,0,20));
		setPane();
	}
	
	public void setPane() {
		
		text.setFont(Font.font("Times Roman",FontWeight.BOLD,FontPosture.ITALIC,24));
		text.getTransforms().add(new Rotate(90));
		getChildren().add(text);
	}
	
	public void setColor(Color color) {
		text.setFill(color);
	}

}

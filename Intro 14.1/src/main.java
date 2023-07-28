import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.geometry.*;

public class main extends Application{
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setVgap(5);
		pane.setHgap(5);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		Image image = new Image("https://www.reuters.com/resizer/-4KPs9QSJzlE4wUJEy_vSDhOwWY=/1200x0/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/F6INOOMSRRL5XOOQDRPZUWPWBA.jpg");
		Image image2 = new Image("https://bd.gaadicdn.com/processedimages/royal-enfield/classic350/640X309/classic350612f277880878.jpg?tr=w-360");
		Image image3 = new Image("https://www.reuters.com/resizer/-4KPs9QSJzlE4wUJEy_vSDhOwWY=/1200x0/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/F6INOOMSRRL5XOOQDRPZUWPWBA.jpg");
		Image image4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/440px-Image_created_with_a_mobile_phone.png");
		
		ImageView imgview = new ImageView(image);
		imgview.setFitHeight(100);
		imgview.setFitWidth(100);
		pane.add(imgview,0,0);
		
		ImageView imgview2 = new ImageView(image2);
		imgview2.setFitHeight(100);
		imgview2.setFitWidth(100);
		pane.add(imgview2, 0, 1);
		
		ImageView imgview3 = new ImageView(image3);
		imgview3.setFitHeight(100);
		imgview3.setFitWidth(100);
		pane.add(imgview3, 1, 0);
		
		ImageView imgview4 = new ImageView(image4);
		imgview4.setFitHeight(100);
		imgview4.setFitWidth(100);
		pane.add(imgview4, 1, 1);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Images");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}

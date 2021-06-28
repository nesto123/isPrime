package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			//BorderPane  root = (BorderPane )FXMLLoader.load(getClass().getResource("Sample.fxml"));
			//Scene scene = new Scene(root,651,426);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);
			//primaryStage.show();
			
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			primaryStage.setTitle("Application");
			primaryStage.setScene(new Scene(root, 651,426));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

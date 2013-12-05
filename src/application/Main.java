package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			final StackPane root = new StackPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			final Button btn = new Button();
			btn.setText("I'm exist");
			btn.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			btn.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					btn.setText("You've clicked me!");
					Timeline tm = new Timeline();
					for(Node btn:root.getChildren()){
						tm.getKeyFrames().addAll(
						        new KeyFrame(Duration.ZERO, // set start position at 0
						            new KeyValue(btn.translateXProperty(), Math.random() * 200),
						            new KeyValue(btn.translateYProperty(), Math.random() * 200)
						        ),
						        new KeyFrame(new Duration(400), // set end position at 40s
						            new KeyValue(btn.translateXProperty(), Math.random() * 200),
						            new KeyValue(btn.translateYProperty(), Math.random() * 200)
						        )
						    );
					}
					tm.play();
					Polyline polyline = new Polyline();
					polyline.getPoints().addAll(new Double[]{
					    0.0, 0.0,
					    200.0, 10.0,
					    10.0, 20.0 });
					polyline.setBlendMode(BlendMode.GREEN);
					root.getChildren().add(polyline);
				}
			});
			root.getChildren().add(btn);			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

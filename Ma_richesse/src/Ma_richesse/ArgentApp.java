package Ma_richesse;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ArgentApp extends Application{
	public static void main(String[] args) {
		launch(args);

	}
	private int moneyInitial =500;
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("Ma_Richesse");
		VBox root = new VBox(10);
		root.setPadding(new Insets(25));
		root.setAlignment(Pos.CENTER);
		ImageView addImage = new ImageView(getClass().getResource("add_icon.png").toString());
		ImageView moinsImage = new ImageView(getClass().getResource("moins_icon.png").toString());
		
		Label statuLabel = new Label("j'ai initialement : 500");
		Button addMoney = new Button("J'ai 500 de plus");
		Button LostMoney = new Button("J'ai 500 de moins");
		//addMoney.setGraphic(addImage);
		//LostMoney.setGraphic(moinsImage);
		addMoney.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				addMoney.setGraphic(addImage);
				
			}
			
		});
		LostMoney.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				LostMoney.setGraphic(moinsImage);
				
			}
			
		});
		addMoney.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				addMoney.setGraphic(addImage);
				
			}
			
		});
		LostMoney.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				LostMoney.setGraphic(moinsImage);
				
			}
			
		});
		addMoney.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent arg0) {
				
				moneyInitial=moneyInitial+500;
				statuLabel.setText("J'ai initialement : " + moneyInitial );
			  
			}
		});
		
		LostMoney.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				if(moneyInitial > 0) {
				moneyInitial=moneyInitial-500;
				statuLabel.setText("J'ai initialement : " + moneyInitial );
			  }
			}
		});
		root.getChildren().addAll(statuLabel, addMoney, LostMoney);
		
		Scene scene = new Scene(root, 300, 150);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

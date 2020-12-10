package com.Interface;

import com.company.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;


public class MyFxApp extends Application {



public void updateGridPane(Grid grid,GridPane gridPane) {

 for (int i = 0; i < grid.getY(); i++) {
  for (int j = 0; j < grid.getX(); j++) {
   System.out.println(grid.getX());
   switch (grid.getSlot(i, j)) {
    case -1:
     gridPane.add(new Circle(100, 100, 15, Color.valueOf("#FF001E")), i, j+1, 1, 1);
     break;
    case 1:
     gridPane.add(new Circle(100, 100, 15, Color.valueOf("#FFDD00")), i, j+1, 1, 1);
     break;
    default:
     gridPane.add(new Circle(100, 100, 15, Color.valueOf("#FFFFFF")), i, j+1, 1, 1);
   }
  }
 }
}

 @Override
 public void start(Stage primaryStage) throws Exception{

  primaryStage.setTitle("Hello World");

  FileInputStream input = new FileInputStream("/Users/achrafmaksi/Desktop/red.png");
  Image image = new Image(input);
  ImageView imageView = new ImageView(image);

  Grid grid = new Grid(6,7);
  grid.initializeGrid();
  grid.updateGrid(3,1);
  grid.updateGrid(1,1);


  GridPane gridPane=new GridPane();

  Button[] playButtons=new Button[grid.getY()];

  for (int i = 0; i <grid.getY() ; i++) {
   playButtons[i]=new Button(Integer.toString(i+1));
    playButtons[i].setOnAction(value ->  {
     Button source = (Button) value.getSource();
     grid.updateGrid(gridPane.getColumnIndex(source), -1);
     updateGridPane(grid,gridPane);
   });
   gridPane.add(playButtons[i],i,0,1,1);
  }



  updateGridPane(grid,gridPane);
  gridPane.setHgap(10);
  gridPane.setVgap(10);

  String styles = "-fx-background-color: #1fca28;";

  //Label label = new Label("Hello World, JavaFX !");
  gridPane.setStyle(styles);

  Scene scene = new Scene(gridPane);
  primaryStage.initStyle(StageStyle.DECORATED);
  primaryStage.setScene(scene);

  Button button = new Button("Button 2");
  button.setStyle("-fx-background-color: #0000ff");

  /*primaryStage.setOnCloseRequest((event) -> {
   System.out.println("Closing Stage");
  });
  primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
   System.out.println("Key pressed: " + event.toString());

   switch(event.getCode().getCode()) {
    case 27 : { // 27 = ESC key
     primaryStage.close();
     break;
    }
    case 10 : { // 10 = Return
     primaryStage.setWidth( primaryStage.getWidth() * 2);
    }
    default:  {
     System.out.println("Unrecognized key");
    }
   }
  }); */

  primaryStage.show();

 }

 public void startScreen() {

 }

 public static void main(String[] args) {

  launch(args);
 }
}

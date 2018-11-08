
package dxball;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DxBall extends Application {
    
    static Stage theStage;
    
    @Override
    public void start(Stage primaryStage) 
    {    
        theStage = primaryStage;
        IntroductoryScene iScene = new IntroductoryScene();
        Scene scene = iScene.getScene();
        primaryStage.setTitle("DxBall");
        primaryStage.setScene(scene);      
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }   
}

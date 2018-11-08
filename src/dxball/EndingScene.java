
package dxball;

import static dxball.DxBall.theStage;
import static dxball.GameplayScene.score;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class EndingScene {
    Pane pane = new Pane();
    Text t1 = new Text(120, 250, "GAME OVER");
    Text t2 = new Text(180, 320, "Your Score Is : " + String.valueOf(score));
    Text t3 = new Text(400, 480, "Press 'C' to continue...");
    Scene getScene()
    {
        t1.setId("t1");
        t2.setId("t2");
        t3.setId("t3");
        pane.getChildren().addAll(t1, t2, t3);
        Scene scene = new Scene(pane, 720, 540);
        scene.getStylesheets().add(DxBall.class.getResource("Ending.css").toExternalForm());
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case C:  
                {
                    score = 0;
                    IntroductoryScene iScene = new IntroductoryScene();
                    Scene newScene = iScene.getScene();
                    theStage.setScene(newScene);
                }    
            }
        });
        return scene;
    }
    
}

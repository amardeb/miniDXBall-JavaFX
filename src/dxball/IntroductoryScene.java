package dxball;

import static dxball.DxBall.theStage;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IntroductoryScene
{
    Text welcomeText = new Text("DxBall");
    Button button1, button2;

    Scene getScene()
    {
        welcomeText.setId("DxBall");
        button1 = new Button("Start Game");
        button1.setOnAction(e->buttonCode(e));
        button2 = new Button("Exit");
        button2.setOnAction(e->buttonCode(e));
        GridPane root = new GridPane();
        VBox root1 = new VBox();
        root.setAlignment(Pos.CENTER);
        root1.setAlignment(Pos.CENTER);
        button1.setPrefWidth(100);
        button2.setPrefWidth(100);
        root1.setSpacing(20);
        root1.getChildren().addAll(button1, button2);
        root.add(welcomeText, 0, 0);
        root.add(root1, 0, 1);
        Scene scene = new Scene(root, 720, 540);
        scene.getStylesheets().add(DxBall.class.getResource("Introductory.css").toExternalForm());
        return scene;
    }

    public void buttonCode(ActionEvent e)
    {
        if(e.getSource()==button1)
        {
            GameplayScene gScene = new GameplayScene();
            Scene scene = gScene.getScene();
            theStage.setScene(scene);
        }
        else
            theStage.close();
    }
}

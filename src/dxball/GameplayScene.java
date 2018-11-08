
package dxball;

import static dxball.DxBall.theStage;
import static dxball.ScorePanel.scoreText;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameplayScene {
    
    static int dx=1, dy=1, score=0, lives=3;
    Pane root = new Pane(); 
    Group group = new Group();
    Rectangle paddle;
    Circle ball;
    ArrayList<Rectangle> bricks = new ArrayList<Rectangle>();
    ScorePanel scorePanel = new ScorePanel();
    Scene scene;
    Timeline timeline = new Timeline();
    GameplayScene() { 
        score = 0;
        scoreText.setText(String.valueOf(score));
    };
    
    Scene getScene()
    {
        root.getChildren().add(group);
        group.setId("group");
        Paddle pShape = new Paddle(300, 500);
        paddle = pShape.getPaddle();
        Ball bShape = new Ball(360, 490);
        ball = bShape.getBall();
        Bricks rShape = new Bricks(70, 90);
        bricks = rShape.getBricks();
        for(Rectangle r : bricks){
            group.getChildren().add(r);
        }
        group = scorePanel.setExtras(group);
        group.getChildren().addAll(paddle, ball);
        scene = new Scene(root, 720, 540);
        scene.getStylesheets().add(DxBall.class.getResource("Gameplay.css").toExternalForm());
        animate();
        return scene;
    }
    
    void animate()
    {
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyframe = new KeyFrame(Duration.millis(4), e->action(e));
        timeline.getKeyFrames().add(keyframe);
        timeline.play();
    }
    
    void action(ActionEvent e)
    {
        Calculate calculate = new Calculate();
        calculate.checkSceneCollision(ball, scene);
        calculate.checkBrickCollision(ball, bricks, group);
        calculate.checkPaddleCollision(ball, paddle);
        calculate.checkLife(ball, paddle, group, scorePanel);
        calculate.checkPaddleMovement(paddle, scene);
        ball.setTranslateX(ball.getTranslateX() + dx);
        ball.setTranslateY(ball.getTranslateY() + dy);
        if(score==55 || lives==0)
        {
            lives = 3;
            EndingScene eScene = new EndingScene();
            Scene newScene = eScene.getScene();
            theStage.setScene(newScene);
            timeline.stop();
        }
    }
}

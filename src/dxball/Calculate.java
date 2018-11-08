
package dxball;

import static dxball.GameplayScene.dx;
import static dxball.GameplayScene.dy;
import static dxball.GameplayScene.lives;
import static dxball.GameplayScene.score;
import static dxball.ScorePanel.scoreText;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Calculate {
    
    void checkBrickCollision(Circle ball, ArrayList<Rectangle> bricks, Group group)
    {
        for(Rectangle r: bricks)
        {
            if(ball.getBoundsInParent().intersects(r.getBoundsInParent()))
            {
                double xMin = ball.getBoundsInParent().getMinX();
                double yMin = ball.getBoundsInParent().getMinY();
                double xMax = ball.getBoundsInParent().getMaxX();
                double yMax = ball.getBoundsInParent().getMaxY();
                if(yMax > r.getBoundsInParent().getMaxY() && yMin >= r.getBoundsInParent().getMaxY()) dy=dy*-1;
                else if(yMax <= r.getBoundsInParent().getMinY() && yMin < r.getBoundsInParent().getMinY()) dy=dy*-1;
                else if(xMax <= r.getBoundsInParent().getMinX() && xMin < r.getBoundsInParent().getMinX()) dx=dx*-1;
                else  dx=dx*-1;
                int i = bricks.indexOf(r);
                bricks.remove(i);
                group.getChildren().remove(r);
                score++;
                scoreText.setText(String.valueOf(score));
                break;
            }
        }
    }
    void checkSceneCollision(Circle ball, Scene scene)
    {
        double xMin = ball.getBoundsInParent().getMinX();
        double yMin = ball.getBoundsInParent().getMinY();
        double xMax = ball.getBoundsInParent().getMaxX();
        double yMax = ball.getBoundsInParent().getMaxY();
        if(xMin < 0) dx = 1;
        if(xMax > scene.getWidth()) dx = -1;
        if(yMin < 0) dy = 1;
        if(yMax > scene.getHeight()) dy = -1;
    }
    
    void checkPaddleCollision(Circle ball, Rectangle paddle)
    {
        if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent()))
        {
            dy = -1;
            double xMin = ball.getBoundsInParent().getMinX();
            double xMax = ball.getBoundsInParent().getMaxX();  
            double pxMin = paddle.getBoundsInParent().getMinX();
            double pxMax = paddle.getBoundsInParent().getMaxX();
            if(xMin < pxMin) dx = -1; 
            else if(xMax > pxMax) dx = 1;             
        }
    }
    
    void checkLife(Circle ball, Rectangle paddle, Group group, ScorePanel scorePanel)
    {
        if(!ball.getBoundsInParent().intersects(paddle.getBoundsInParent()) && ball.getBoundsInParent().getMaxY() > 535)
        {
            lives--;
            scorePanel.decreaseLife(group);
            ball.setTranslateX(0);
            ball.setTranslateY(-50);
            
            dy = -1;
        }
    }
    
    void checkPaddleMovement(Rectangle paddle, Scene scene)
    {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT: 
                {
                    if(paddle.getBoundsInParent().getMinX() >= 0)
                        paddle.setTranslateX(paddle.getTranslateX() - 15);
                    break;
                }
                case RIGHT: 
                {
                    if(paddle.getBoundsInParent().getMaxX() <= scene.getWidth())
                        paddle.setTranslateX(paddle.getTranslateX() + 15);
                    break;
                }
            }
        });
    }
    
}

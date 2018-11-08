
package dxball;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ScorePanel {
    int lives=3;
    Text tLife = new Text(550, 30, "Life:");
    Text score = new Text(20, 30, "Score:");
    static Text scoreText = new Text(100, 30, "0");
    ArrayList<Circle> balls = new ArrayList<Circle>();
    ScorePanel()
    {
        tLife.setId("life");
        score.setId("score");
        scoreText.setId("scoreText");
        for(int i = 0; i<lives; i++)
        {
            Ball bShape = new Ball(620+i*22, 23);
            Circle ball = bShape.getBall();
            balls.add(ball);
        }
    }
    Group setExtras(Group g)
    {
        for(Circle c : balls){
            g.getChildren().add(c);
        }
        g.getChildren().addAll(tLife, score, scoreText);
        return g;
    }
    void decreaseLife(Group g)
    {
        Circle ball = balls.get(balls.size()-1);
        g.getChildren().remove(ball);
        balls.remove(balls.size()-1);
    }
}

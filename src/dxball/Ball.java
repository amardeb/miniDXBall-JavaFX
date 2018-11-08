
package dxball;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Ball extends Shapes{
    int radius = 10;
    Ball(int x, int y)
    {
        super(x, y);
    }
    Circle getBall()
    {
        Circle ball = new Circle(x, y, radius);
        Stop[] stops = new Stop[] { new Stop(0, Color.GREY), new Stop(1, Color.BLACK)};
        RadialGradient r = new RadialGradient(0,0.1, ball.getCenterX(), ball.getCenterY(), 20, false, CycleMethod.NO_CYCLE, stops);
        ball.setFill(r);
        return ball;
    }
}

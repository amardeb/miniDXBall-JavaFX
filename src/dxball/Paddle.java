
package dxball;

import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Paddle extends Shapes{
    int width = 120, height = 18;
    Paddle(int x, int y)
    {
        super(x, y);
    }
    Rectangle getPaddle()
    {
        Rectangle paddle = new Rectangle(x, y, width, height);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.DARKCYAN)};
        LinearGradient l = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        paddle.setStroke(Color.BLACK);
        paddle.setArcHeight(10);
        paddle.setArcWidth(10);
        paddle.setFill(l);
        return paddle;
    }
}

package Controller;

import Model.Player;

import java.awt.*;

/**
 * Created by Yunus Ölez on 18.12.2016.
 */
public class CollisionDetector
{
    // Final Values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;

    public void CheckForCollision (Player player)
    {
        Robot robot;
        int r = player.getSize()/2;
        Point centerPoint = new Point (player.getCurrentPoint().x + r, player.getCurrentPoint().y + r);
        Point pointToCheck = new Point ((int)(centerPoint.x + r*Math.cos(player.getDirection() * Math.PI / 180)),
                (int)(centerPoint.y + r*Math.sin(player.getDirection() * Math.PI / 180)));

        try {
            robot = new Robot();

            if (!robot.getPixelColor(pointToCheck.x, pointToCheck.y).equals(Color.BLACK) || pointToCheck.x < 0 ||
                    pointToCheck.x > SCREEN_WIDTH || pointToCheck.y < 0 || pointToCheck.y > SCREEN_HEIGHT)
            {
                System.out.println("A COLLUSION HAS OCCURRED! Player: " + player.getColor());
                player.killPlayer();
            }
        } catch (Exception e) {
            System.out.println("An error occurred while trying to detect a collision!");
        }
    }
}

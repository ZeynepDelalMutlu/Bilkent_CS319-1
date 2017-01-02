package Controller;
import java.awt.*;
import Model.Player;
import Model.PowerUp;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class CollisionDetector
{
    // Final Values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;

    // Variables
    private PowerUp[] powerUps;

    public CollisionDetector (PowerUp[] allPowerUps)
    {
        powerUps = allPowerUps;
    }

    public boolean isPointEmpty (int x, int y)
    {
        Robot robot;

        try {
            robot = new Robot();

            if (!robot.getPixelColor(x, y).equals(Color.BLACK))
            {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred in isPointEmpty()");
            return false;
        }
    }

    void CheckForCollision(Player player)
    {
        Robot robot;
        int r = player.getSize()/2;
        Point centerPoint = new Point (player.getCurrentPoint().x + r, player.getCurrentPoint().y + r);
        Point pointToCheck = new Point ((int)(centerPoint.x + r*Math.cos(player.getDirection() * Math.PI / 180)),
                (int)(centerPoint.y + r*Math.sin(player.getDirection() * Math.PI / 180)));

        try {
            robot = new Robot();

            if (robot.getPixelColor(pointToCheck.x, pointToCheck.y).equals(powerUps[0].getColor()))
            {
                powerUps[0].killPowerUp();
                powerUps[0].startEffectTimer(player);
            }
            else if (robot.getPixelColor(pointToCheck.x, pointToCheck.y).equals(powerUps[1].getColor()))
            {
                powerUps[1].killPowerUp();
                powerUps[1].startEffectTimer(player);
            }
            else if (robot.getPixelColor(pointToCheck.x, pointToCheck.y).equals(powerUps[2].getColor()))
            {
                powerUps[2].killPowerUp();
                powerUps[2].startEffectTimer(player);
            }
            else if (!robot.getPixelColor(pointToCheck.x, pointToCheck.y).equals(Color.BLACK) || pointToCheck.x < 0 ||
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

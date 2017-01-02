package Controller;
import java.awt.*;
import View.GamePanel;
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

public class PowerUpSpawner
{
    // Final values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;
    private final int CHANCE_OF_SPAWNING_POWERUP = 1; // CHANCE_OF_SPAWNING_POWERUP/100

    // Variables
    CollisionDetector cd;
    GamePanel gamePanel;
    PowerUp[] powerUps;

    public PowerUpSpawner (CollisionDetector aCD, GamePanel aGP, PowerUp[] allPowerUps)
    {
        cd = aCD;
        gamePanel = aGP;
        powerUps = allPowerUps;
    }

    public boolean shouldSpawnPowerUp ()
    {
        int decider = (int) (100*Math.random());
        boolean isThereAnyEmpty = false;

        for (int i = 0; i < powerUps.length; i++)
        {
            if (!powerUps[i].isAlive())
            {
                isThereAnyEmpty = true;
                i = powerUps.length;
            }
        }

        if (decider <= CHANCE_OF_SPAWNING_POWERUP && isThereAnyEmpty)
        {
            return true;
        }
        return false;
    }

    public void spawnPowerUp ()
    {
        Point newPoint = createRandomPoint();
        int decider = (int) (powerUps.length*Math.random());

        while (powerUps[decider].isAlive())
            decider = (int) (powerUps.length*Math.random());

        powerUps[decider] = new PowerUp(powerUps[decider].getType(), newPoint, gamePanel);
    }

    private Point createRandomPoint ()
    {
        int x = (int) (SCREEN_WIDTH*Math.random());
        int y = (int) (SCREEN_HEIGHT*Math.random());

        while (!cd.isPointEmpty(x, y))
        {
            x = (int) (SCREEN_WIDTH*Math.random());
            y = (int) (SCREEN_HEIGHT*Math.random());
        }

        return new Point(x, y);
    }
}

import java.awt.*;

/**
 * Created by Yunus Ölez on 18.12.2016.
 */
public class GameController
{
    // Final Values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;

    // Variables
    private Player[] players;
    private PowerUp[] powerUps;
    private CollisionDetector collisionDetector;
    private GamePanel gamePanel;
    private MoveController moveController;
    private PowerUpSpawner powerUpSpawner;
    private boolean isEveryPlayerDead;

    public GameController (Player[] allPlayers)
    {
        players = allPlayers;
        PowerUp type0PowerUp = new PowerUp(0);
        PowerUp type1PowerUp = new PowerUp(1);
        PowerUp type2PowerUp = new PowerUp(2);
        powerUps = new PowerUp[3];
        powerUps[0] = type0PowerUp;
        powerUps[1] = type1PowerUp;
        powerUps[2] = type2PowerUp;
        isEveryPlayerDead = false;

        collisionDetector = new CollisionDetector(powerUps);
        gamePanel = new GamePanel(players, powerUps);
        moveController = new MoveController(players, gamePanel);
        powerUpSpawner = new PowerUpSpawner(collisionDetector, gamePanel, powerUps);
    }

    private void setStartingPoints()
    {
        int heightMargin = SCREEN_HEIGHT/(players.length+1);
        boolean shouldDirectionBeZero = true;

        for (int i = 0; i < players.length; i++)
        {
            if (shouldDirectionBeZero)
            {
                players[i].setDirection(0);
                shouldDirectionBeZero = false;
            }
            else
            {
                players[i].setDirection(180);
                shouldDirectionBeZero = true;
            }
            players[i].setCurrentPoint(new Point(SCREEN_WIDTH/2, heightMargin));
            heightMargin += SCREEN_HEIGHT/(players.length+1);
        }
    }

    void startGame()
    {
        setStartingPoints();

        gamePanel.paintCountdown(3);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        gamePanel.paintCountdown(0);
        try
        {
            Thread.sleep(500);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        gamePanel.paintCountdown(2);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        gamePanel.paintCountdown(0);
        try
        {
            Thread.sleep(500);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        gamePanel.paintCountdown(1);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        gamePanel.paintCountdown(0);
        try
        {
            Thread.sleep(250);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }

        while (!isEveryPlayerDead)
        {
            gamePanel.paint();
            moveController.moveAllPlayers();
            isEveryPlayerDead = true;

            for (int i = 0; i < players.length; i++)
            {
                if (players[i].isPlayerAlive())
                {
                    collisionDetector.CheckForCollision(players[i]);
                    isEveryPlayerDead = false;
                }
            }

            if (powerUpSpawner.shouldSpawnPowerUp())
            {
                powerUpSpawner.spawnPowerUp();
            }
        }
    }
}

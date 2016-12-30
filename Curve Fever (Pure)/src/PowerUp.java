import java.awt.*;
import javax.swing.*;

/**
 * Created by Yunus Ölez on 19.12.2016.
 */

// if (type == 0) -> PowerUp will half the size of the player.
// if (type == 1) -> PowerUp will double the speed of the player.
// if (type == 2) -> PowerUp will change the left and right key configuration of the player.
public class PowerUp
{
    // Final values
    private final Color TYPE_0_COLOR = Color.MAGENTA;
    private final Color TYPE_1_COLOR = Color.CYAN;
    private final Color TYPE_2_COLOR = Color.ORANGE;
    private final int FIXED_SIZE = 30;
    private final int LIFE_TIME = 20000; // in milliseconds
    private final int EFFECT_TIME = 10000; // in milliseconds

    // Variables
    private Point currentPoint;
    private Color color;
    private boolean isAlive;
    private int type;
    private int size;
    private Timer lifeTime;
    private GamePanel gamePanel;
    private Timer effectTimer;
    private Player effectedPlayer;

    public PowerUp (int aType)
    {
        type = aType;

        if (type == 0)
        {
            color = TYPE_0_COLOR;
        }
        else if (type == 1)
        {
            color = TYPE_1_COLOR;
        }
        else if (type == 2)
        {
            color = TYPE_2_COLOR;
        }
    }
    public PowerUp (int aType, Point aPoint, GamePanel aGP)
    {
        type = aType;
        currentPoint = aPoint;
        gamePanel = aGP;
        isAlive = true;
        size = FIXED_SIZE;
        lifeTime = new Timer(LIFE_TIME, actionListener -> {
            killPowerUp();
        });
        startLifeTime();

        if (type == 0)
        {
            color = TYPE_0_COLOR;
        }
        else if (type == 1)
        {
            color = TYPE_1_COLOR;
        }
        else if (type == 2)
        {
            color = TYPE_2_COLOR;
        }
        effectTimer = new Timer(EFFECT_TIME, actionListener -> {

            effectTimer.stop();

            if (type == 0)
            {
                effectedPlayer.setSize(effectedPlayer.FIXED_SIZE);
            }
            else if (type == 1)
            {
                effectedPlayer.setSpeed(effectedPlayer.FIXED_SPEED);
            }
            else if (type == 2)
            {
                int leftKeyConfig = effectedPlayer.getLeftKeyConfig();

                effectedPlayer.setLeftKeyConfig(effectedPlayer.getRightKeyConfig());
                effectedPlayer.setRightKeyConfig(leftKeyConfig);
            }
            effectedPlayer = null;
        });
    }

    public Point getCurrentPoint ()
    {
        return currentPoint;
    }
    public void setCurrentPoint (Point newPoint)
    {
        currentPoint = newPoint;
    }
    public Color getColor ()
    {
        return color;
    }
    public void setColor (Color newColor)
    {
        color = newColor;
    }
    public boolean isAlive ()
    {
        return isAlive;
    }
    public void killPowerUp ()
    {
        isAlive = false;
        lifeTime.stop();
        gamePanel.clearPowerUp(this);
    }
    public int getType ()
    {
        return type;
    }
    public void setType (int aType)
    {
        type = aType;
    }
    public int getSize ()
    {
        return size;
    }
    public void setSize (int aSize)
    {
        size = aSize;
    }
    public void startLifeTime ()
    {
        lifeTime.start();
    }
    public void startEffectTimer (Player aPlayer)
    {
        effectedPlayer = aPlayer;
        effectTimer.start();

        if (type == 0)
        {
            effectedPlayer.setSize(effectedPlayer.FIXED_SIZE/2);
        }
        else if (type == 1)
        {
            effectedPlayer.setSpeed(effectedPlayer.FIXED_SPEED*2);
        }
        else if (type == 2)
        {
            int leftKeyConfig = effectedPlayer.getLeftKeyConfig();

            effectedPlayer.setLeftKeyConfig(effectedPlayer.getRightKeyConfig());
            effectedPlayer.setRightKeyConfig(leftKeyConfig);
        }
    }
}

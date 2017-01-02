package Model;

import java.awt.*;
import javax.swing.*;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class Player
{
    // Final Values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;
    final int FIXED_SIZE = 12;
    final int FIXED_SPEED = 6;

    // Variables
    private String name;
    private Point currentPoint;
    private int direction;
    private Timer inputLagAvoider; // Needed to avoid lags when getting input inside the MoveController class
    private boolean isGoingLeft; // Needed to be used in MoveController
    private int leftKeyConfig;
    private int rightKeyConfig;
    private Color color;
    private int size;
    private boolean isAlive;
    private int speed;

    public Player (String aName, int lkc, int rkc, Color aColor)
    {
        name = aName;
        currentPoint = new Point (SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
        direction = 0;
        isGoingLeft = false;
        inputLagAvoider = new Timer(10, actionListener -> {
            if (isGoingLeft)
            {
                if (direction <= 0)
                    direction = 359;
                else
                    direction -= 2;
            }
            else
            {
                if (direction >= 359)
                    direction = 0;
                else
                    direction += 2;
            }
        });
        leftKeyConfig = lkc;
        rightKeyConfig = rkc;
        color = aColor;
        size = FIXED_SIZE;
        isAlive = true;
        speed = FIXED_SPEED;
    }

    public String getName () { return name; }
    public Point getCurrentPoint ()
    {
        return currentPoint;
    }
    public void setCurrentPoint (Point newPoint)
    {
        currentPoint = newPoint;
    }
    public int getDirection ()
    {
        return direction;
    }
    public void setDirection (int newDirection)
    {
        direction = newDirection;
    }
    public int getLeftKeyConfig ()
    {
        return leftKeyConfig;
    }
    public void setLeftKeyConfig (int newLeftKeyConfig)
    {
        leftKeyConfig = newLeftKeyConfig;
    }
    public int getRightKeyConfig ()
    {
        return rightKeyConfig;
    }
    public void setRightKeyConfig (int newRightKeyConfig)
    {
        rightKeyConfig = newRightKeyConfig;
    }
    public boolean getIsGoingLeft ()
    {
        return isGoingLeft;
    }
    public void setIsGoingLeft (boolean newBool)
    {
        isGoingLeft = newBool;
    }
    public void startTimer ()
    {
        inputLagAvoider.start();
    }
    public void stopTimer ()
    {
        inputLagAvoider.stop();
    }
    public Color getColor ()
    {
        return color;
    }
    public void setColor (Color newColor)
    {
        color = newColor;
    }
    public int getSize ()
    {
        return size;
    }
    public void setSize (int newSize)
    {
        size = newSize;
    }
    public boolean isPlayerAlive ()
    {
        return isAlive;
    }
    public void killPlayer ()
    {
        isAlive = false;
    }
    public int getSpeed () { return speed; }
    public void setSpeed (int aSpeed) { speed = aSpeed; }
}

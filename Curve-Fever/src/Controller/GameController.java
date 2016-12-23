package Controller;

import Model.Player;
import View.CanvasView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Yunus Ölez on 18.12.2016.
 */
public class GameController
{
    private CanvasView canvasView;
    private Player[] players;

    public GameController(CanvasView canvasView){
        this.canvasView = canvasView;

        setStartingPoints(players);
        MoveController mc = new MoveController(players);
        CollisionDetector cd = new CollisionDetector();

        mc.paintCountdown(3);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        mc.paintCountdown(0);
        try
        {
            Thread.sleep(500);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        mc.paintCountdown(2);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        mc.paintCountdown(0);
        try
        {
            Thread.sleep(500);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        mc.paintCountdown(1);
        try
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }
        mc.paintCountdown(0);
        try
        {
            Thread.sleep(250);
        } catch (Exception e)
        {
            System.out.println("Error!");
        }

        while (true)
        {
            mc.paint();
            mc.moveAllPlayers();

            for (int i = 0; i < players.length; i++)
            {
                if (players[i].isPlayerAlive())
                    cd.CheckForCollision(players[i]);
            }

            try
            {
                Thread.sleep(100);
            } catch (Exception e)
            {
                System.out.println("Error!");

            }
        }
    }
    // This method should be inside the GameController class. Also, the method should not take any parameters. Also,
    // the method should not be static.
    public static void setStartingPoints (Player[] players)
    {
        final int SCREEN_HEIGHT = 762;
        final int SCREEN_WIDTH = 732;
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
}

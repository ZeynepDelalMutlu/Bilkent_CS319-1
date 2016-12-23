package Controller;

import Model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Created by Yunus Ölez on 15.12.2016.
 */
public class MoveController extends JFrame implements KeyListener
{
    // Final Values
    private final int FONT_SIZE = 75;
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;

    // Variables
    Player[] players;

    public MoveController (Player[] allPlayers)
    {
        this.addKeyListener(this);
        setSize(1000, 600); // STATIC
        setVisible(true);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        players = allPlayers;
    }

    public void moveAllPlayers ()
    {
        Point currentPoint;
        int direction;

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].isPlayerAlive())
            {
                currentPoint = players[i].getCurrentPoint();
                direction = players[i].getDirection();

                players[i].setCurrentPoint(new Point((int) (currentPoint.x + 4 * Math.cos(direction * Math.PI / 180)),
                        (int) (currentPoint.y + 4 * Math.sin(direction * Math.PI / 180))));
            }
        }
    }

    @Override
    public void keyPressed (KeyEvent e)
    {
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].isPlayerAlive())
            {
                if (e.getKeyCode() == players[i].getLeftKeyConfig()) {
                    players[i].setIsGoingLeft(true);
                    players[i].startTimer();
                } else if (e.getKeyCode() == players[i].getRightKeyConfig()) {
                    players[i].setIsGoingLeft(false);
                    players[i].startTimer();
                }
            }
        }
    }
    @Override public void keyReleased (KeyEvent e)
    {
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].isPlayerAlive())
            {
                if (e.getKeyCode() == players[i].getLeftKeyConfig() || e.getKeyCode() == players[i].getRightKeyConfig()) {
                    players[i].stopTimer();
                }
            }
        }
    }
    @Override public void keyTyped (KeyEvent e) {}

    public void paintCountdown (int count)
    {
        Graphics g = getGraphics();

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, FONT_SIZE));

        if (count == 3)
            g.drawString("3",SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
        else if (count == 2)
            g.drawString("2", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        else if (count == 1)
            g.drawString("1", SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        else if (count == 0)
        {
            g.setColor(Color.BLACK);
            g.fillRect(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
            g.setColor(Color.WHITE);
        }
    }

    public void paint ()
    {
        Graphics g = getGraphics();
        Point currentPoint;

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].isPlayerAlive())
            {
                currentPoint = players[i].getCurrentPoint();

                g.setColor(players[i].getColor());
                g.fillOval(currentPoint.x, currentPoint.y, players[i].getSize(), players[i].getSize());
            }
        }
    }

//    public Point findHeadPoint (Point currentPoint)
//    {
//        Point centerPoint = new Point(currentPoint.x+6, currentPoint.y+6); // NEED CHANGES WHEN ADDING PLAYER
//
//        return new Point(6*Math.cos(direction))
//   }
}

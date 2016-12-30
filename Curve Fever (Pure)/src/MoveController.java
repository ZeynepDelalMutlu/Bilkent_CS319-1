
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Yunus Ölez on 15.12.2016.
 */
public class MoveController implements KeyListener
{
    // Variables
    Player[] players;
    GamePanel gamePanel;

    public MoveController (Player[] allPlayers, GamePanel aGP)
    {
        gamePanel = aGP;
        gamePanel.addKeyListener(this);

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

                players[i].setCurrentPoint(new Point((int) (currentPoint.x + players[i].getSpeed() * Math.cos(direction * Math.PI / 180)),
                        (int) (currentPoint.y + players[i].getSpeed() * Math.sin(direction * Math.PI / 180))));
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
}

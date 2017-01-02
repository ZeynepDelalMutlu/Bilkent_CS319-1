package View;
import javax.swing.*;
import java.awt.*;
import Model.PowerUp;
import Model.Player;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class GamePanel extends JFrame
{
    // Final values
    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 600;
    private final int FONT_SIZE = 75;

    // Variables
    private Player[] players;
    private PowerUp[] powerUps;

    public GamePanel(Player[] allPlayers, PowerUp[] allPowerUps)
    {
        players = allPlayers;
        powerUps = allPowerUps;

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFocusable(true);
        requestFocusInWindow();
    }

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

    public void clearPowerUp (PowerUp powerUp)
    {
        Graphics g = getGraphics();

        g.setColor(Color.BLACK);
        g.fillOval(powerUp.getCurrentPoint().x, powerUp.getCurrentPoint().y, powerUp.getSize(), powerUp.getSize());
    }

    public void paint ()
    {
        Graphics g = getGraphics();
        Point currentPoint;
        int size;

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].isPlayerAlive())
            {
                currentPoint = players[i].getCurrentPoint();
                size = players[i].getSize();

                g.setColor(players[i].getColor());
                g.fillOval(currentPoint.x, currentPoint.y, size, size);
            }
        }

        for (int i = 0; i < powerUps.length; i++)
        {
            if (powerUps[i].isAlive())
            {
                currentPoint = powerUps[i].getCurrentPoint();
                size = powerUps[i].getSize();

                g.setColor(powerUps[i].getColor());
                g.fillOval(currentPoint.x, currentPoint.y, size, size);
            }
        }
    }
}

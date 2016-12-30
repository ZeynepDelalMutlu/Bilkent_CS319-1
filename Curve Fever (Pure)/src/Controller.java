import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Created by Yunus Ölez on 24.12.2016.
 */
public class Controller
{
    public Controller(Player[] players)
    {

        GameController gameController = new GameController(players);
        gameController.startGame();
    }

    public static void main(String[] args)
    {
        // Variables
        Controller controller;
        Player[] players;
        int numberOfPlayers = 0;
        Scanner scan = new Scanner(System.in);

        while (numberOfPlayers < 1)
        {
            System.out.println("Please enter the number of players: ");
            numberOfPlayers = scan.nextInt();
        }

        players = new Player[numberOfPlayers];

        for(int i = 0; i < numberOfPlayers; i++)
        {
            // Local Variables
            String name;
            int leftKeyConfig = 0;
            int rightKeyConfig = 0;
            Color color = null;

            System.out.println("Please enter the name of player " + i + ": ");
            name = scan.next();
            while(leftKeyConfig == 0)
            {
                System.out.println("Please enter the left key configuration of player " + i + ": ");
                leftKeyConfig = convertAscii2KeyEvent(scan.next().charAt(0));
            }
            while (rightKeyConfig == 0)
            {
                System.out.println("Please enter the right key configuration of player " + i + ": ");
                rightKeyConfig = convertAscii2KeyEvent(scan.next().charAt(0));
            }
            while (color == null)
            {
                System.out.print("Please enter one of the colors for player: " + i + ": ");
                System.out.println("(white, blue, cyan, gray, green, magenta, orange, pink, red, yellow)");
                color = getColor(scan.next());
            }
            players[i] = new Player(name, leftKeyConfig, rightKeyConfig, color);
        }

        controller = new Controller(players);
    }

    static int convertAscii2KeyEvent (int asciiCode)
    {
        switch (asciiCode)
        {
            case 32: return KeyEvent.VK_SPACE;
            case 48: return KeyEvent.VK_0;
            case 49: return KeyEvent.VK_1;
            case 50: return KeyEvent.VK_2;
            case 51: return KeyEvent.VK_3;
            case 52: return KeyEvent.VK_4;
            case 53: return KeyEvent.VK_5;
            case 54: return KeyEvent.VK_6;
            case 55: return KeyEvent.VK_7;
            case 56: return KeyEvent.VK_8;
            case 57: return KeyEvent.VK_9;
            case 60: return KeyEvent.VK_LEFT;
            case 62: return KeyEvent.VK_RIGHT;
            case 97: return KeyEvent.VK_A;
            case 98: return KeyEvent.VK_B;
            case 99: return KeyEvent.VK_C;
            case 100: return KeyEvent.VK_D;
            case 101: return KeyEvent.VK_E;
            case 102: return KeyEvent.VK_F;
            case 103: return KeyEvent.VK_G;
            case 104: return KeyEvent.VK_H;
            case 105: return KeyEvent.VK_I;
            case 106: return KeyEvent.VK_J;
            case 107: return KeyEvent.VK_K;
            case 108: return KeyEvent.VK_L;
            case 109: return KeyEvent.VK_M;
            case 110: return KeyEvent.VK_N;
            case 111: return KeyEvent.VK_O;
            case 112: return KeyEvent.VK_P;
            case 113: return KeyEvent.VK_Q;
            case 114: return KeyEvent.VK_R;
            case 115: return KeyEvent.VK_S;
            case 116: return KeyEvent.VK_T;
            case 117: return KeyEvent.VK_U;
            case 118: return KeyEvent.VK_V;
            case 119: return KeyEvent.VK_W;
            case 120: return KeyEvent.VK_X;
            case 121: return KeyEvent.VK_Y;
            case 122: return KeyEvent.VK_Z;
        }
        return 0;
    }

    static Color getColor (String color)
    {
        switch (color)
        {
            case "white": return Color.white;
            case "blue": return Color.blue;
            case "cyan": return Color.cyan;
            case "gray": return Color.gray;
            case "green": return Color.green;
            case "magenta": return Color.magenta;
            case "orange": return Color.orange;
            case "pink": return Color.pink;
            case "red": return Color.red;
            case "yellow": return Color.yellow;
        }
        return null;
    }
}

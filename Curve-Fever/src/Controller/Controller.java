package Controller;
import Model.Player;

import View.CanvasView;

import javax.swing.*;
import java.awt.*;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class Controller {

    public static void main(String[] args) {

        int playerNumber;
        CanvasView canvasView = new CanvasView();
        //Player[] players;

        JFrame frame = new JFrame("Curve Fever");

        frame.setPreferredSize(new Dimension(1024,768));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.getContentPane().add(canvasView);
        frame.pack();
        frame.setVisible(true);

        while(true){
            System.out.println("Buraya girildi mi? ");
            if(canvasView.getShouldStartGame()){
                playerNumber = canvasView.getPlayerNumber();
                System.out.println("buraya giriyoz mu biz ya :D");
                Player[] players = new Player[playerNumber];
                players = canvasView.getPlayers();
                for(int i = 0; i < playerNumber; i++){
                    System.out.println("bu player ismi: " + players[i].getName());
                }
                GameController gameController = new GameController(players);
                gameController.startGame();
               break;
            }
        }

    }
}

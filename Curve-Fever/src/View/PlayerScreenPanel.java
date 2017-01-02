package View;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class PlayerScreenPanel extends JPanel{

    private CanvasView canvasView;
    private Insets insets;
    private JButton editButton;
    private JButton startButton;
    private Dimension size;
    private JLabel playerLabel;
    private JLabel nameLabel, colorLabel, keyLabel;
    private int playerNumber;
    private Player[] players;

    public PlayerScreenPanel( CanvasView canvasView ){
        this.canvasView = canvasView;
        int startingXCoordinate = 200;
        int startingYCoordinate = 100;

        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        setPlayerNumber(canvasView.getPlayerNumber());
        players = new Player[playerNumber];
        players =  canvasView.getPlayers();

        // BUTTONs: startButton and editButton
        startButton = buttonDesigner("Start");
        buttonPlacer(startButton, 900+ insets.left, 690 + insets.top);
        editButton = buttonDesigner("edit Player");
        buttonPlacer(editButton, 10+insets.left, 690+insets.top);

        for(int i = 0; i<playerNumber; i++){
            //TODO: color and key labels have to be designed.
            // 3 LABELS: name, color, key
            nameLabel = textDesigner("Name:\t\t" + players[i].getName(), 20);
            textPlacer(nameLabel, startingXCoordinate + insets.left, (startingYCoordinate + 30+(30*(i+1)))  + insets.top);

            colorLabel = textDesigner("Color Selection", 20);
            textPlacer(colorLabel, startingXCoordinate + insets.left, (startingYCoordinate + 30+(30*(i+2))) + insets.top);
            colorLabel.setForeground(players[i].getColor());

            keyLabel = textDesigner("Key Configuration: " + players[i].getLeftKeyConfig() + ", " + players[i].getRightKeyConfig(), 20);
            textPlacer(keyLabel, startingXCoordinate + insets.left, (startingYCoordinate + 30+(30*(i+3))) + insets.top);

            startingYCoordinate = startingYCoordinate + 30+(30*(i+3));
        }
    }

    public void setPlayerNumber(int playerNumber){
        this.playerNumber = playerNumber;
    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(30));
        button.addActionListener(new PlayerScreenPanel.ButtonActionListener());
        button.addMouseListener(new PlayerScreenPanel.ButtonMouseListener());
        return button;
    }

    private void buttonPlacer(JButton button, int x, int y){
        size = button.getPreferredSize();
        button.setBounds(x, y, size.width, size.height);
        add(button);
    }

    private JLabel textDesigner(String text, int size){
        JLabel label = new JLabel(text);
        label.setFont(font(size));
        label.setForeground(Color.WHITE);
        return label;
    }

    private void textPlacer(JLabel label, int x, int y){
        size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        add(label);
    }

    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }


    private class ButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == editButton) {
                players = null;
                CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getEditPlayer());
            }
            if(e.getSource() == startButton){
                canvasView.shouldStartGame(true);
                //CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                //cardLayout.show(canvasView, canvasView.getMainMenu());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == editButton)
                editButton.setForeground(new Color(47, 165, 255));
            if(e.getSource() == startButton)
                startButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            editButton.setForeground(Color.WHITE);
            startButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
    }

}

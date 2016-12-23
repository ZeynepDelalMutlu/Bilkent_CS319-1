package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;

/**
 * Created by zeded on 18.12.2016.
 */
public class RemovePlayerPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton backButton;
    private JButton[] removeButtons;
    private Dimension size;
    private JLabel playerLabel;
    private JLabel head;
    private int playerNumber;
    //private String currentPlayerName;
    private int index;
    private int indexRemovePlayer;

    public RemovePlayerPanel(CanvasView canvasView) {
        this.canvasView = canvasView;
        setPlayerNumber(canvasView.getPlayerNumber());
        removeButtons = new JButton[playerNumber];
        int startingXCoordinate = 200;
        int startingYCoordinate = 200;

        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        // HEAD
        head = textDesigner("Choose to delete a player: ", 30);
        textPlacer(head, startingXCoordinate + insets.left, 150 + insets.top);

        // BUTTONs: backButton and removeButtons
        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 10 + insets.left, 690 + insets.top);

        for (index = 0; index < playerNumber; index++) {
            playerLabel = textDesigner("PLAYER " + (index+1), 30);
            textPlacer(playerLabel, startingXCoordinate + insets.left, (startingYCoordinate + 30 + (30 * (index + 1))) + insets.top);
            removeButtons[index] = exitButtonDesigner("X");
            buttonPlacer(removeButtons[index], startingXCoordinate + 200 + insets.left, (startingYCoordinate + 35 + (30 * (index + 1))) + insets.top);
            add(removeButtons[index]);

            startingYCoordinate = startingYCoordinate + 35 + (30 * (index + 1));
        }
    }

    public void setPlayerNumber(int playerNumber){
        this.playerNumber = playerNumber;
    }

    public int getPlayerSize(){
        return playerNumber;
    }

    public void setIndexRemovePlayer(int indexRemovePlayer){
        this.indexRemovePlayer = indexRemovePlayer;
    }

    public int getIndexRemovePlayer(){
        return indexRemovePlayer;
    }

    private JButton exitButtonDesigner (String text) {
        JButton button = new JButton(text);
        String nameEachExitButton = index + "";
        button.setName(nameEachExitButton);
        System.out.println(nameEachExitButton + " bu exitButton ismi");

        button.setPreferredSize(new Dimension(20, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.white, Color.white, Color.black));
        button.setFont(font(15));

        button.addActionListener(new View.RemovePlayerPanel.ButtonActionListener());
        button.addMouseListener(new View.RemovePlayerPanel.ButtonMouseListener());

        return button;
    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(30));

        button.addActionListener(new View.RemovePlayerPanel.ButtonActionListener());
        button.addMouseListener(new View.RemovePlayerPanel.ButtonMouseListener());

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

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlayerScreen());
            }

            for(int k = 0; k<playerNumber; k++){
                if(e.getSource() == removeButtons[k]){
                    System.out.println(removeButtons[k].getName() + " burası button");
                    canvasView.setIndexRemovePlayer(k);
                    canvasView.removePlayer();
                    setIndexRemovePlayer(-1);
                    CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getAddPlayer());
                    break;
                }
            }
        }
    }

    private class ButtonMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == backButton)
                backButton.setForeground(new Color(47, 165, 255));
            for(int k = 0; k<playerNumber; k++){
                if(e.getSource() == removeButtons[k])
                    (removeButtons[k]).setForeground(new Color(47, 165, 255));
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            backButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
    }
}
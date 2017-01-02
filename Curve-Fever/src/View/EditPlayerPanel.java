package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.BevelBorder;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class EditPlayerPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton backButton;
    private JButton[] removeButtons;
    private JButton[] editButtons;
    private Dimension size;
    private JLabel playerLabel;
    private JLabel head;

    private int playerNumber;
    private int index;
    private int indexEditPlayer;
    private int indexRemovePlayer;
    private boolean playersEdited = false;

    public EditPlayerPanel(CanvasView canvasView) {
        this.canvasView = canvasView;
        setPlayerNumber(canvasView.getPlayerNumber());
        editButtons = new JButton[playerNumber];
        removeButtons = new JButton[playerNumber];
        int startingXCoordinate = 200;
        int startingYCoordinate = 200;

        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        // HEAD
        head = textDesigner("Choose 'X' to delete a player.\nChoose 'O' to edit a player. ", 30);
        textPlacer(head, startingXCoordinate + insets.left, 150 + insets.top);

        // BUTTONs: backButton and editButtons
        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 10 + insets.left, 690 + insets.top);

        for (index = 0; index < getPlayerSize(); index++) {
            playerLabel = textDesigner("PLAYER " + (index+1), 30);
            textPlacer(playerLabel, startingXCoordinate + insets.left, (startingYCoordinate + 30 + (30 * (index + 1))) + insets.top);

            removeButtons[index] = removeButtonDesigner("X");
            buttonPlacer(removeButtons[index], startingXCoordinate + 200 + insets.left, (startingYCoordinate + 35 + (30 * (index + 1))) + insets.top);

            editButtons[index] = editButtonDesigner("O");
            buttonPlacer(editButtons[index], startingXCoordinate + 250 + insets.left, (startingYCoordinate + 35 + (30 * (index + 1))) + insets.top);

            add(removeButtons[index]);
            add(editButtons[index]);

            startingYCoordinate = startingYCoordinate + 35 + (30 * (index + 1));
        }
    }

    public void setPlayersEdited(boolean playersEdited){
        this.playersEdited = playersEdited;
    }

    public boolean getPlayersEdited(){
        return playersEdited;
    }

    public void setPlayerNumber(int playerNumber){
            this.playerNumber = playerNumber;
        }

    public int getPlayerSize(){
        return playerNumber;
    }

    public void setIndexEditPlayer(int indexEditPlayer){
            this.indexEditPlayer = indexEditPlayer;
        }

    public int getIndexEditPlayer(){
        return indexEditPlayer;
    }

    public int getIndexRemovePlayer(){
        return indexRemovePlayer;
    }

    public void setIndexRemovePlayer(int indexRemovePlayer){
        this.indexRemovePlayer = indexRemovePlayer;
    }

    private JButton editButtonDesigner (String text) {
        JButton button = new JButton(text);
        String nameEachExitButton = index + ".editButton";
        button.setName(nameEachExitButton);

        button.setPreferredSize(new Dimension(20, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.white, Color.white, Color.black));
        button.setFont(font(15));

        button.addActionListener(new View.EditPlayerPanel.ButtonActionListener());
        button.addMouseListener(new View.EditPlayerPanel.ButtonMouseListener());
        return button;
    }

    private JButton removeButtonDesigner (String text) {
        JButton button = new JButton(text);
        String nameEachExitButton = index + ".removeButton";
        button.setName(nameEachExitButton);

        button.setPreferredSize(new Dimension(20, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.white, Color.white, Color.black));
        button.setFont(font(15));

        button.addActionListener(new View.EditPlayerPanel.ButtonActionListener());
        button.addMouseListener(new View.EditPlayerPanel.ButtonMouseListener());
        return button;
    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(30));

        button.addActionListener(new View.EditPlayerPanel.ButtonActionListener());
        button.addMouseListener(new View.EditPlayerPanel.ButtonMouseListener());
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
                if(e.getSource() == editButtons[k]){
                    setPlayersEdited(true);
                    canvasView.setPlayersEdited(true);
                    canvasView.setIndexEditPlayer(k);
                    canvasView.makeEditPlayerNull();
                    CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getAddPlayer());
                    break;
                }
            }
            for(int k = 0; k<playerNumber; k++){
                if(e.getSource() == removeButtons[k]){
                    setIndexRemovePlayer(k);
                    canvasView.setIndexRemovePlayer(k);
                    canvasView.deletePlayer();
                    CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getPlayerScreen());
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
                if(e.getSource() == editButtons[k])
                    (editButtons[k]).setForeground(new Color(47, 165, 255));
            }
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


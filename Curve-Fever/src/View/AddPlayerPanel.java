package View;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

public class AddPlayerPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton continueButton;
    private JButton backButton;
    private JTextField playerNameField, key1, key2;
    private JComboBox colorSelection;
    private Dimension size;
    private JLabel q1, q2, q3;
    private JLabel header;
    private Color color = Color.RED;
    private int playerNumber;
    private int currentPlayerNumber;
    private String playerName;

    public AddPlayerPanel(int currentPlayerNumber, int playerNumber, CanvasView canvasView){
        this.canvasView = canvasView;
        this.playerNumber = playerNumber;
        this.currentPlayerNumber = currentPlayerNumber;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        // BUTTONS
        continueButton = buttonDesigner("Continue");
        buttonPlacer(continueButton, 900+ insets.left, 690 + insets.top);
        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 10+insets.left, 690+insets.top);

        // HEADER
        header = textDesigner(("PLAYER #" + currentPlayerNumber) , 50);
        textPlacer(header, 270+ insets.left, 170 + insets.top);

        // 3 LABELS: name, color, key
        q1 = textDesigner("Player Name:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);
        playerNameField = new JTextField("", 10);
        playerNameField.setBorder(BorderFactory.createEmptyBorder());
        playerNameField.setFont(font(25));
        playerNameField.setHorizontalAlignment(JTextField.CENTER);
        size = playerNameField.getPreferredSize();
        playerNameField.setBounds(550+ insets.left, 250 + insets.top, size.width, size.height);
        add(playerNameField);

        q2 = textDesigner("Color Selection:", 30);
        textPlacer(q2, 270 + insets.left, 300 + insets.top);
        //TO DO: burda color selection kodu yazmalıyız.

        q3 = textDesigner("Key Configuration:", 30);
        textPlacer(q3, 270 + insets.left, 350 + insets.top);
        key1 = new JTextField("", 2);
        key1.setBorder(BorderFactory.createEmptyBorder());
        key1.setFont(font(25));
        key1.setHorizontalAlignment(JTextField.CENTER);
        size = key1.getPreferredSize();
        key1.setBounds(550+ insets.left, 350 + insets.top, size.width, size.height);
        add(key1);
        key2 = new JTextField("", 2);
        key2.setBorder(BorderFactory.createEmptyBorder());
        key2.setFont(font(25));
        key2.setHorizontalAlignment(JTextField.CENTER);
        size = key2.getPreferredSize();
        key2.setBounds(610+ insets.left, 350 + insets.top, size.width, size.height);
        add(key2);
    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(30));

        button.addActionListener(new AddPlayerPanel.ButtonActionListener());
        button.addMouseListener(new AddPlayerPanel.ButtonMouseListener());

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

    public String getPlayerName(){
        return playerName;
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO CONTINUE BUTTON
            if(e.getSource() == continueButton) {
                if(currentPlayerNumber<playerNumber) {
                    System.out.println("BUTTON");
                    playerName = playerNameField.getText();
                    System.out.println("current player number: " +currentPlayerNumber +" addplayer continue basıldı "+ playerName);
                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getAddPlayer(playerName));
                    System.out.println("ÖNEMLİ: player name(after calling nextplayer)" + playerName);
                }
                else{
                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getMainMenu());
                }
            }
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlay());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == continueButton)
                continueButton.setForeground(new Color(47, 165, 255));
            if(e.getSource() == backButton)
                backButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            continueButton.setForeground(Color.WHITE);
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
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

    public AddPlayerPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        // BUTTONS
        continueButton = buttonDesigner("Continue");
        buttonPlacer(continueButton, 900+ insets.left, 690 + insets.top);
        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 10+insets.left, 690+insets.top);

        // HEADER
        header = textDesigner(("PLAYER#" + (canvasView.getCurrentPlayerNumber())) , 50);
        textPlacer(header, 270+ insets.left, 170 + insets.top);

        // 3 LABELS: name, color, key
        q1 = textDesigner("Player Name:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);

        playerNameField = textFieldCreateAndChecker(550+insets.left, 250+insets.top);
        add(playerNameField);

        q2 = textDesigner("Color Selection:", 30);
        textPlacer(q2, 270 + insets.left, 300 + insets.top);

        //TODO:Color Selection

        q3 = textDesigner("Key Configuration:", 30);
        textPlacer(q3, 270 + insets.left, 350 + insets.top);

        key1 = textFieldCreateAndChecker(550+ insets.left, 350 + insets.top);
        key2 = textFieldCreateAndChecker(610+ insets.left, 350 + insets.top);

        add(key1);
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

    private JTextField textFieldCreateAndChecker(int x, int y){
        JTextField textField = new JTextField("", 2);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(font(25));
        textField.setHorizontalAlignment(JTextField.CENTER);
        size = textField.getPreferredSize();
        textField.setBounds(x, y, size.width, size.height);

        return textField;
    }

    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == continueButton) {
                if(canvasView.getCurrentPlayerNumber()-1 < canvasView.getPlayerNumber()){

                    Player player = new Player(playerNameField.getText());

                    canvasView.getPlayers()[canvasView.getCurrentPlayerNumber()-1] = player;
                    canvasView.setCurrentPlayerNumber(canvasView.getCurrentPlayerNumber()+1);

                    header.setText("PLAYER#" + canvasView.getCurrentPlayerNumber());

                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getAddPlayer());
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
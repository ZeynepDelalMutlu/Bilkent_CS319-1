package View;

import Model.Player;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.security.Key;

public class AddPlayerPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton continueButton;
    private JButton backButton;
    private JButton colorButton;
    private JTextField playerNameField, key1, key2;


    private Dimension size;
    private JLabel q1, q2, q3;
    private JLabel header;

    private String name;
    private int keyL;
    private int keyR;

    private Color color;

    private int indexShouldCreateNewPlayer = -1;
    private int tempIndex;

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
        colorButton = buttonDesigner("Choose Color");
        buttonPlacer(colorButton, 550 + insets.left, 300 + insets.top );

        // This block indicates which player should created again.
        tempIndex = canvasView.getCurrentPlayerNumber()-1;
        if(indexShouldCreateNewPlayer >= 0){
            canvasView.setCurrentPlayerNumber(indexShouldCreateNewPlayer + 1);
        }

        // HEADER
        header = textDesigner(("PLAYER#" + (canvasView.getCurrentPlayerNumber())) , 50);
        textPlacer(header, 270+ insets.left, 170 + insets.top);

        // 3 LABELS: name, color, key
        q1 = textDesigner("Player Name:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);

        playerNameField = textFieldCreateAndChecker(550+insets.left, 250+insets.top, 6);
        add(playerNameField);

        q2 = textDesigner("Color Selection:", 30);
        textPlacer(q2, 270 + insets.left, 300 + insets.top);

        q3 = textDesigner("Key Configuration:", 30);
        textPlacer(q3, 270 + insets.left, 350 + insets.top);

        key1 = textFieldCreateAndChecker(550+ insets.left, 350 + insets.top, 2);
        key2 = textFieldCreateAndChecker(610+ insets.left, 350 + insets.top, 2);

        key1.addKeyListener(new KeyInputListener());
        key2.addKeyListener(new KeyInputListener());

        add(key1);
        add(key2);

        // Set currentPlayerNumber real version.
        // That's why we decide panels with respect to currentPlayerNumber real version.
        // Therefore, this block has to be at the end of the constructor.
        if(indexShouldCreateNewPlayer >= 0){
            canvasView.setCurrentPlayerNumber(tempIndex + 1);
        }
    }

    public void setRemoveIndex(int indexShouldCreateNewPlayer){
        this.indexShouldCreateNewPlayer = indexShouldCreateNewPlayer;
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

    private JTextField textFieldCreateAndChecker(int x, int y, int columns){
        JTextField textField = new JTextField("", columns);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(font(25));
        textField.setHorizontalAlignment(JTextField.CENTER);
        size = textField.getPreferredSize();
        textField.setBounds(x, y, size.width, size.height);

        textField.getDocument().addDocumentListener(new TextFieldDocumentListener());
        return textField;
    }

    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }

    private boolean playerInfoChecker(){
        if(!(playerNameField.getText() == null || playerNameField.getText().trim().isEmpty())){
            if(!(key1.getText() == null || key1.getText().trim().isEmpty())) {
                if (!(key2.getText() == null || key2.getText().trim().isEmpty())) {
                    continueButton.setEnabled(true);
                    return true;
                }
            }
        }
        return false;
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == continueButton) {
                if(canvasView.getCurrentPlayerNumber() < canvasView.getPlayerNumber() && indexShouldCreateNewPlayer < 0){

                    if(playerInfoChecker()) {
                        Player player = new Player(name, keyL, keyR, color);

                        canvasView.setPlayer(player);
                        canvasView.setCurrentPlayerNumber(canvasView.getCurrentPlayerNumber() + 1);

                        header.setText("PLAYER#" + canvasView.getCurrentPlayerNumber());
                        playerNameField.setText("");
                        key1.setText("");
                        key2.setText("");
                        q2.setForeground(Color.WHITE);

                        CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                        cardLayout.show(canvasView, canvasView.getAddPlayer());
                    }
                }

                else if(canvasView.getCurrentPlayerNumber() >= canvasView.getPlayerNumber()&& indexShouldCreateNewPlayer < 0){
                    Player player = new Player(name, keyL, keyR, color);

                    canvasView.setPlayer(player);
                    canvasView.setCurrentPlayerNumber(canvasView.getCurrentPlayerNumber() + 1);
                    playerNameField.setText("");
                    key1.setText("");
                    key2.setText("");
                    q2.setForeground(Color.WHITE);

                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getPlayerScreen());
                }

                else{
                    Player player = new Player(name, keyL, keyR, color);

                    // setPlayer(player) method is working with currentPlayerNumber,
                    // That's why we change currentPlayerNumber.
                    int tempIndex = canvasView.getCurrentPlayerNumber()-1;
                    canvasView.setCurrentPlayerNumber(indexShouldCreateNewPlayer+1);
                    canvasView.setPlayer(player);
                    canvasView.setCurrentPlayerNumber(tempIndex+1);

                    indexShouldCreateNewPlayer = -1;

                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getPlayerScreen());
                }
            }
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlay());
            }
            if(e.getSource() == colorButton){
                color = JColorChooser.showDialog(canvasView, "Choose Player Color", canvasView.getBackground());
                q2.setForeground(color);
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
            if(e.getSource() == colorButton)
                colorButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            continueButton.setForeground(Color.WHITE);
            backButton.setForeground(Color.WHITE);
            colorButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
    }

    private class TextFieldDocumentListener implements DocumentListener{
        @Override
        public void changedUpdate(DocumentEvent e) {
            warn();
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
            warn();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            warn();
        }
        public void warn(){
            if(!(playerNameField.getText() == null || playerNameField.getText().trim().isEmpty())) {
                name = playerNameField.getText();
                System.out.println(name);
            }
            /*if(!(key1.getText() == null || key1.getText().trim().isEmpty())) {
                keyL = Integer.parseInt(key1.getText());
                //keyL = KeyEvent.getExtendedKeyCodeForChar(keyL);
                System.out.println(keyL);
            }*/
            /*if(!(key2.getText() == null || key2.getText().trim().isEmpty())) {
                keyR = Integer.parseInt(key2.getText());
                String a = KeyEvent.getKeyText(keyR);
                System.out.println(a);
            }*/
        }
    }

    private class KeyInputListener implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {
            displayInfo(e, "KEY TYPED: ");
        }
        @Override
        public void keyReleased(KeyEvent e) {
            displayInfo(e, "KEY RELEASED");
        }
        @Override
        public void keyTyped(KeyEvent e) {
            displayInfo(e, "KEY TYPED");
        }

        private void displayInfo(KeyEvent e, String keyStatus){
            int id = e.getID();
            String keyString;
            if(e.getSource() == key1) {
                if (id == KeyEvent.KEY_TYPED) {
                    char c = e.getKeyChar();
                    keyString = "key character = " + c + " :=)";
                    System.out.println(keyString);
                } else {
                    int keyCode = e.getKeyCode();
                    keyString = "key code: " + keyCode + " :=)";
                    //System.out.println(keyString);
                    keyL = keyCode;
                    System.out.println(keyL);
                }
            }
            if(e.getSource() == key2) {
                if (id == KeyEvent.KEY_TYPED) {
                    char c = e.getKeyChar();
                    keyString = "key character = " + c + " :=)";
                    System.out.println(keyString);
                } else {
                    int keyCode = e.getKeyCode();
                    keyString = "key code: " + keyCode + " :=)";
                    //System.out.println(keyString);
                    keyR = keyCode;
                    System.out.println(keyR);
                }
            }

        }
    }
}
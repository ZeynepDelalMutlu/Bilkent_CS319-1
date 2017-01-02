package View;

import Model.Player;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

/**
 *  CS-319 PROJECT: CURVE FEWER
 *
 *  Contributers:   Barış Polat         |    Instructor:  Bora Güngören
 *                  Yunus Ölez          |
 *                  Zeynep Delal Mutlu  |
 *
 *  edited on 31.12.2016
 */

public class AddPlayerPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton continueButton;
    private JButton backButton;
    private JButton okayButton;
    private JTextField playerNameField, key1, key2;
    //private JComboBox colorSelection;
    //private Color color = Color.RED;
    private Dimension size;
    private JLabel q1, q2, q3;
    private JLabel header;
    //private JPanel normalPanel;
    //private JPanel editedPanel;

    private int indexShouldCreateNewPlayer = -1;
    private int tempIndex;
    private int playerNumber;
    private int currentPlayerNumber;
    private String newHead;
    private boolean playersEdited = false;

    private String name; //Barışın yazdığı kod başlangıç
    private int keyL;
    private int keyR;

    private int keyLeft;
    private int keyRight;

    private JButton colorButton;
    private Color color; //Barışın yazdığı kod bitiş

    public AddPlayerPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        // BUTTONS
        if(getPlayersEdited()){
            okayButton = buttonDesigner("Okay");
            buttonPlacer(okayButton, 500+ insets.left, 500 + insets.top);
            colorButton = buttonDesigner("Choose Color");
            buttonPlacer(colorButton, 550 + insets.left, 300 + insets.top );
        }
        else{
            continueButton = buttonDesigner("Continue");
            buttonPlacer(continueButton, 900+ insets.left, 690 + insets.top);
            backButton = buttonDesigner("Back");
            buttonPlacer(backButton, 10+insets.left, 690+insets.top);
            colorButton = buttonDesigner("Choose Color");
            buttonPlacer(colorButton, 550 + insets.left, 300 + insets.top );
        }

        // This block indicates which player should created again.
        indexShouldCreateNewPlayer = canvasView.getIndexEditPlayer();
        setCurrentPlayerNumber(canvasView.getCurrentPlayerNumber());
        tempIndex = currentPlayerNumber-1;
        if(indexShouldCreateNewPlayer >= 0){
            canvasView.setCurrentPlayerNumber(indexShouldCreateNewPlayer + 1);
        }

        // HEADER
        newHead = ("PLAYER#" + (canvasView.getCurrentPlayerNumber()));
        header = textDesigner(newHead , 50);
        textPlacer(header, 270+ insets.left, 170 + insets.top);

        // 3 LABELS: name, color, key
        q1 = textDesigner("Player Name:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);

        playerNameField = textFieldCreateAndChecker(550+insets.left, 250+insets.top);
        add(playerNameField);

        q2 = textDesigner("Color Selection:", 30);
        textPlacer(q2, 270 + insets.left, 300 + insets.top);

        q3 = textDesigner("Key Configuration:", 30);
        textPlacer(q3, 270 + insets.left, 350 + insets.top);

        key1 = textFieldCreateAndChecker(550+ insets.left, 350 + insets.top);
        key2 = textFieldCreateAndChecker(610+ insets.left, 350 + insets.top);

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

    public JButton getBackJButton(){
        return backButton;
    }

    public JButton getContinueJButton(){
        return continueButton;
    }

    public JButton getOkayJButton(){
        okayButton = buttonDesigner("Okay");
        buttonPlacer(okayButton, 500+ insets.left, 500 + insets.top);
        return okayButton;
    }

    public void setPlayersEdited(boolean playersEdited){
        this.playersEdited = playersEdited;
    }

    public boolean getPlayersEdited(){
        return playersEdited;
    }

    public void setHead(String newHead){
        header.setText(newHead);
    }

    public String getHead(){
        return newHead;
    }

    public void setEditIndex(int indexShouldCreateNewPlayer){
        this.indexShouldCreateNewPlayer = indexShouldCreateNewPlayer;
    }

    public int getEditIndex(){
        return indexShouldCreateNewPlayer;
    }

    public void setPlayerNumber(int playerNumber){
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public void setCurrentPlayerNumber(int CurrentPlayerNumber){
        this.currentPlayerNumber = currentPlayerNumber;
    }

    public int getCurrentPlayerNumber(){
        return currentPlayerNumber;
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

                //TODO: Burayı sadece if-else olarak yazarken nedenini anlayamadığım bir hata aldım :S
                if(canvasView.getCurrentPlayerNumber() < canvasView.getPlayerNumber() && indexShouldCreateNewPlayer < 0){
                    if(playerInfoChecker()) {
                        Player player = new Player(playerNameField.getText(), keyL, keyR, color);

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

                    Player player = new Player(playerNameField.getText(), keyL, keyR, color);

                    player.setLeftKeyConfig(keyLeft);
                    player.setRightKeyConfig(keyRight);

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

                    player.setLeftKeyConfig(keyLeft);
                    player.setRightKeyConfig(keyRight);

                    // setPlayer(player) method is working with currentPlayerNumber,
                    // That's why we change currentPlayerNumber.
                    int tempIndex = canvasView.getCurrentPlayerNumber()-1;
                    canvasView.setCurrentPlayerNumber(indexShouldCreateNewPlayer+1);
                    canvasView.setPlayer(player);
                    canvasView.setCurrentPlayerNumber(tempIndex+1);
                    //q2.setForeground(Color.WHITE);

                    indexShouldCreateNewPlayer = -1;

                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getPlayerScreen());
                }
            }

            if(e.getSource() == backButton){
                canvasView.setPlayersEdited(false);
                canvasView.setPlayers(null);
                canvasView.setPlayerNumber(0);
                canvasView.setCurrentPlayerNumber(1);
                canvasView.setIndexRemovePlayer(-1);
                canvasView.setIndexEditPlayer(-1);
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlay());
            }

            if(e.getSource() == okayButton){

                Player player = new Player(name, keyL, keyR, color);

                // setPlayer(player) method is working with currentPlayerNumber,
                // That's why we changes currentPlayerNumber.
                int tempIndex = canvasView.getCurrentPlayerNumber()-1;
                canvasView.setCurrentPlayerNumber(indexShouldCreateNewPlayer+1);
                canvasView.setPlayer(player);
                canvasView.setCurrentPlayerNumber(tempIndex+1);

                //indexShouldCreateNewPlayer = -1;
                playerNameField.setText("");
                key1.setText("");
                key2.setText("");

                //q2.setForeground(Color.WHITE);

                CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlayerScreen());
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
            if(e.getSource() == okayButton)
                okayButton.setForeground(new Color(47, 165, 255));
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

    //Barışın eklediği kod parçası

    private class TextFieldDocumentListener implements DocumentListener {
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

    public int convertKeyEvent(char character) {
        switch (character) {
            case 'a': return (KeyEvent.VK_A);
            case 'b': return (KeyEvent.VK_B);
            case 'c': return (KeyEvent.VK_C);
            case 'd': return (KeyEvent.VK_D);
            case 'e': return (KeyEvent.VK_E);
            case 'f': return (KeyEvent.VK_F);
            case 'g': return (KeyEvent.VK_G);
            case 'h': return (KeyEvent.VK_H);
            case 'i': return (KeyEvent.VK_I);
            case 'j': return (KeyEvent.VK_J);
            case 'k': return (KeyEvent.VK_K);
            case 'l': return (KeyEvent.VK_L);
            case 'm': return (KeyEvent.VK_M);
            case 'n': return (KeyEvent.VK_N);
            case 'o': return (KeyEvent.VK_O);
            case 'p': return (KeyEvent.VK_P);
            case 'q': return (KeyEvent.VK_Q);
            case 'r': return (KeyEvent.VK_R);
            case 's': return (KeyEvent.VK_S);
            case 't': return (KeyEvent.VK_T);
            case 'u': return (KeyEvent.VK_U);
            case 'v': return (KeyEvent.VK_V);
            case 'w': return (KeyEvent.VK_W);
            case 'x': return (KeyEvent.VK_X);
            case 'y': return (KeyEvent.VK_Y);
            case 'z': return (KeyEvent.VK_Z);
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
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
                    keyLeft = convertKeyEvent(c);
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
                    keyRight = convertKeyEvent(c);
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
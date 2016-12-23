package View;

import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Baris Poyraz on 13.12.2016.
 */
public class PlayerSelectionPanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private JButton continueButton;
    private JButton backButton;
    private JTextField playerField;
    private Dimension size;
    private JLabel q1;
    private JLabel note;

    private Player[] p;

    public PlayerSelectionPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        continueButton = buttonDesigner("Continue");
        buttonPlacer(continueButton, 900+ insets.left, 690 + insets.top);

        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 10+insets.left, 690+insets.top);

        q1 = textDesigner("Number of Players:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);

        playerField = textFieldCreateAndChecker();
        add(playerField);

        note = textDesigner("Note: In order to start the game, at least 2 players are needed", 20);
        textPlacer(note, 270 + insets.left, 300 + insets.top);

    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(30));

        button.addActionListener(new ButtonActionListener());
        button.addMouseListener(new ButtonMouseListener());

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

    private JTextField textFieldCreateAndChecker(){
        JTextField textField = new JTextField("2", 5);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setFont(font(25));
        textField.setHorizontalAlignment(JTextField.CENTER);

        size = textField.getPreferredSize();
        textField.setBounds(550+ insets.left, 250 + insets.top, size.width, size.height);

        return textField;
    }

    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }

    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == continueButton) {

                try{
                    canvasView.setPlayerNumber(Integer.parseInt(playerField.getText()));

                    if(Integer.parseInt(playerField.getText()) < 2){
                        throw new IllegalArgumentException("");
                    }
                    p = new Player[canvasView.getPlayerNumber()];
                    canvasView.setPlayers(p);

                    CardLayout cardLayout = (CardLayout) (canvasView.getLayout());
                    cardLayout.show(canvasView, canvasView.getAddPlayer());

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(canvasView,"Enter a number that is at least 2");
                }
                catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(canvasView, "Enter a number that is at least 2");
                }
            }
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getMainMenu());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener{
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
        public void mousePressed(MouseEvent e) {
            backButton.setContentAreaFilled(false);
        }
        @Override
        public void mouseClicked(MouseEvent e) {}
    }
}
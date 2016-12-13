package View;

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
    private JTextField playerField;
    private Dimension size;
    private JLabel q1;

    public PlayerSelectionPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        continueButton = buttonDesigner("Continue");
        buttonPlacer(continueButton, 900+ insets.left, 690 + insets.top);

        q1 = textDesigner("Number of Players:", 30);
        textPlacer(q1, 270+ insets.left, 250 + insets.top);

        playerField = new JTextField("2", 5);
        playerField.setBorder(BorderFactory.createEmptyBorder());
        playerField.setFont(font(25));
        playerField.setHorizontalAlignment(JTextField.CENTER);

        size = playerField.getPreferredSize();
        playerField.setBounds(550+ insets.left, 250 + insets.top, size.width, size.height);
        add(playerField);
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

    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }

    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == continueButton)
                continueButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            continueButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
    }
}

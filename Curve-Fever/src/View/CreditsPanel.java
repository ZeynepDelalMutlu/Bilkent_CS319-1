package View;

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

public class CreditsPanel extends JPanel {

    private CanvasView canvasView;
    private JButton backButton;
    private JLabel heading;
    private JLabel credits1;
    private JLabel credits2;
    private JLabel credits3;

    private Insets insets;
    private Dimension size;

    public CreditsPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 940+ insets.left, 690 + insets.top);

        heading = textDesigner("Credits");
        credits1 = textDesigner("<html>This project is part of CS319<br>course in Bilkent University.</html>" );
        credits2 = textDesigner("<html><center>Barış Poyraz<br>Yunus Ölez<br>Zeynep Delal Mutlu</center></html>");
        credits3 = textDesigner("<html><center>Special thanks to<br>Bora Güngören</center></html>");

        textPlacer(heading,470+ insets.left, 80 + insets.top);
        textPlacer(credits1, 350, 200);
        textPlacer(credits2, 400, 350);
        textPlacer(credits3, 425, 500);
    }
    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font());

        button.addActionListener(new ButtonActionListener());
        button.addMouseListener(new ButtonMouseListener());

        return button;
    }

    private void buttonPlacer(JButton button, int x, int y){
        size = button.getPreferredSize();
        button.setBounds(x, y, size.width, size.height);
        add(button);
    }

    private JLabel textDesigner(String text) {
        JLabel label = new JLabel(text);
        label.setFont(font());
        label.setForeground(Color.WHITE);
        return label;
    }

    private void textPlacer(JLabel label, int x, int y) {
        size = label.getPreferredSize();
        label.setBounds(x, y, size.width, size.height);
        add(label);
    }

    private Font font(){
        return new Font("Calibri", Font.PLAIN, 30);
    }

    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getMainMenu());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == backButton){
                backButton.setForeground(new Color(47, 165, 255));
            }
        }
        @Override
        public void mouseExited(MouseEvent e) {
            backButton.setForeground(Color.WHITE);
        }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
    }
}

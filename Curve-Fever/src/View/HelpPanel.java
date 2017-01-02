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

public class HelpPanel extends JPanel {

    private JButton backButton;
    private CanvasView canvasView;
    private JLabel ins;
    private JLabel helpLabel;
    private Insets insets;
    private Dimension size;

    public HelpPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        backButton = buttonDesigner("Back",30);
        buttonPlacer(backButton,940+ insets.left, 690 + insets.top);
        ins = textDesigner("Help",40);
        textPlacer(ins, 470+ insets.left, 80 + insets.top);

        helpLabel = textDesigner("<html>You will start off as a dot in a map, suddenly you start moving.<br> While " +
                "you are moving you leave patterns behind you. Then by<br> using the keyboard keys of your selection, " +
        "you can give<br> directions: left and right. The aim of the game is not to cross<br> other players line and " +
                "be the last one standing. Good Luck!</html>", 25);
        textPlacer(helpLabel, 200+insets.left, 200+insets.top );
    }

    private JButton buttonDesigner(String text, int size){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(font(size));

        button.addActionListener(new ButtonActionListener());
        button.addMouseListener(new ButtonMouseListener());

        return button;
    }

    private void buttonPlacer(JButton button, int x, int y){
        size = button.getPreferredSize();
        button.setBounds(x, y, size.width, size.height);
        add(button);
    }

    private JLabel textDesigner(String text,int size){
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
            if(e.getSource() == backButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getMainMenu());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) {
            backButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == backButton){
                backButton.setForeground(new Color(47, 165, 255));
            }
        }
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
    }
}

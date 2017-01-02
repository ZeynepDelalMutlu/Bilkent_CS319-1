package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Color;
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

public class MainMenuPanel extends JPanel {

    private JButton playButton;
    private JButton settingsButton;
    private JButton helpButton;
    private JButton creditsButton;

    private Border border;

    private JLabel title1;
    private JLabel title2;

    private Insets insets;
    private Dimension size;

    private CanvasView canvasView;

    public MainMenuPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);

        insets = super.getInsets();

        titleDesigner();
        playButton = buttonDesigner("Play");
        settingsButton = buttonDesigner("Settings");
        helpButton = buttonDesigner("Help");
        creditsButton = buttonDesigner("Credits");

        buttonPlacer(playButton, 500+ insets.left, 360 + insets.top);
        buttonPlacer(settingsButton, 500+ insets.left, 435);
        buttonPlacer(helpButton, 500+ insets.left, 510 + insets.top );
        buttonPlacer(creditsButton,920+ insets.left, 690 + insets.top);

    }

    private void titleDesigner(){
        border = BorderFactory.createEmptyBorder();

        String curve = "Curve";
        String fever = "Fever";

        title1 = new JLabel(curve);
        title1.setForeground(new Color(159,49,178));
        title1.setFont(fontTitle());

        title2 = new JLabel(fever);
        title2.setForeground(new Color(255, 106, 0));
        title2.setFont(fontTitle());

        add(title1);
        add(title2);

        insets = super.getInsets();
        size = title1.getPreferredSize();

        title1.setLocation(400, 125);
        title1.setSize(400,200);

        title2.setLocation(515,175);
        title2.setSize(400,200);
    }

    private JButton buttonDesigner(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(fontButton());
        button.setBorder(BorderFactory.createEmptyBorder());

        button.addMouseListener(new ButtonMouseListener());
        button.addActionListener(new ButtonActionListener());

        return button;
    }

    private void buttonPlacer(JButton button, int x, int y){

        size = button.getPreferredSize();
        button.setBounds(x, y, size.width, size.height);

        add(button);
    }

    private Font fontTitle(){
        return new Font("Calibri", Font.PLAIN, 50);
    }
    private Font fontButton() {
        return new Font("Calibri", Font.PLAIN, 30);
    }

    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == playButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getPlay());
            }
            if(e.getSource() == settingsButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getSettings());
            }
            if(e.getSource() == helpButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getHelp());
            }
            if(e.getSource() == creditsButton){
                CardLayout cardLayout = (CardLayout)(canvasView.getLayout());
                cardLayout.show(canvasView, canvasView.getCredits());
            }
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == playButton)
                playButton.setForeground(new Color(47, 165, 255));
            if(e.getSource() == settingsButton)
                settingsButton.setForeground(new Color(47, 165, 255));
            if(e.getSource() == helpButton)
                helpButton.setForeground(new Color(47, 165, 255));
            if(e.getSource() == creditsButton)
                creditsButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) {
            playButton.setForeground(Color.WHITE);
            settingsButton.setForeground(Color.WHITE);
            helpButton.setForeground(Color.WHITE);
            creditsButton.setForeground(Color.WHITE);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            //creditsButton.setContentAreaFilled(false);
        }
        @Override
        public void mouseReleased(MouseEvent e) { }
    }
}

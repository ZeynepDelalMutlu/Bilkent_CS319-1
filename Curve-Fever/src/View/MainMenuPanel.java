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
 * Created by Baris Poyraz on 8.12.2016.
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

        titleDesigner();
        buttonDesigner();


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

    private void buttonDesigner(){

        playButton = new JButton("Play");
        settingsButton = new JButton("Settings");
        helpButton = new JButton("Help");
        creditsButton = new JButton("Credits");

        border = BorderFactory.createEmptyBorder();

        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setBorder(border);
        playButton.setFont(fontButton());

        settingsButton.setBackground(Color.BLACK);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setBorder(border);
        settingsButton.setFont(fontButton());

        helpButton.setBackground(Color.BLACK);
        helpButton.setForeground(Color.WHITE);
        helpButton.setBorder(border);
        helpButton.setFont(fontButton());

        creditsButton.setBackground(Color.BLACK);
        creditsButton.setForeground(Color.WHITE);
        creditsButton.setBorder(border);
        creditsButton.setFont(fontButton());

        playButton.addMouseListener(new ButtonMouseListener());
        settingsButton.addMouseListener(new ButtonMouseListener());
        helpButton.addMouseListener(new ButtonMouseListener());
        creditsButton.addMouseListener(new ButtonMouseListener());

        playButton.addActionListener(new ButtonActionListener());
        settingsButton.addActionListener(new ButtonActionListener());
        helpButton.addActionListener(new ButtonActionListener());
        creditsButton.addActionListener(new ButtonActionListener());

        buttonPlacer();
    }

    private void buttonPlacer(){
        insets = super.getInsets();

        size = playButton.getPreferredSize();
        playButton.setBounds(500+ insets.left, 360 + insets.top, size.width, size.height);

        size = settingsButton.getPreferredSize();
        settingsButton.setBounds(500+ insets.left, 435 + insets.top, size.width, size.height);

        size = helpButton.getPreferredSize();
        helpButton.setBounds(500+ insets.left, 510 + insets.top, size.width, size.height);

        size = creditsButton.getPreferredSize();
        creditsButton.setBounds(920+ insets.left, 690 + insets.top, size.width, size.height);

        add(playButton);
        add(settingsButton);
        add(helpButton);
        add(creditsButton);
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
            if(e.getSource() == playButton){
                playButton.setForeground(new Color(47, 165, 255));
            }
            if(e.getSource() == settingsButton){
                settingsButton.setForeground(new Color(47, 165, 255));
            }
            if(e.getSource() == helpButton){
                helpButton.setForeground(new Color(47, 165, 255));
            }
            if(e.getSource() == creditsButton){
                creditsButton.setForeground(new Color(47, 165, 255));
            }
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
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
    }

}

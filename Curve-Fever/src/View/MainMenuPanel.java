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

    private JPanel textPanel;
    private JPanel buttonPanel;

    private JLabel title1;
    private JLabel title2;

    private BorderLayout borderLayout;

    private CanvasView canvasView;

    public MainMenuPanel(CanvasView canvasView){
        super(new BorderLayout());
        this.canvasView = canvasView;
        setBackground(Color.BLACK);


        titleDesigner();
        add(textPanel, BorderLayout.NORTH);
        buttonDesigner();
        add(buttonPanel, BorderLayout.CENTER);

    }

    public void titleDesigner(){
        textPanel = new JPanel();
        textPanel.setBackground(Color.BLACK);

        String curve = "Curve";
        String fever = "Fever";

        title1 = new JLabel(curve);
        title1.setForeground(new Color(159,49,178));
        title1.setFont(new Font( super.getName() , Font.PLAIN, 60  ));

        title2 = new JLabel(fever);
        title2.setForeground(new Color(255, 106, 0));
        title2.setFont(new Font("Calibri", Font.PLAIN, 60));

        textPanel.add(title1);
        textPanel.add(title2);

        textPanel.setLocation(500,500);
    }

    public void buttonDesigner(){
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);

        Box box = Box.createVerticalBox();

        playButton = new JButton("Play");
        settingsButton = new JButton("Settings");
        helpButton = new JButton("Help");
        creditsButton = new JButton("Credits");

        border = BorderFactory.createEmptyBorder();

        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setBorder(border);

        settingsButton.setBackground(Color.BLACK);
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setBorder(border);

        helpButton.setBackground(Color.BLACK);
        helpButton.setForeground(Color.WHITE);
        helpButton.setBorder(border);

        creditsButton.setBackground(Color.BLACK);
        creditsButton.setForeground(Color.WHITE);
        creditsButton.setBorder(border);


        playButton.addMouseListener(new ButtonMouseListener());
        settingsButton.addMouseListener(new ButtonMouseListener());
        helpButton.addMouseListener(new ButtonMouseListener());
        creditsButton.addMouseListener(new ButtonMouseListener());

        playButton.addActionListener(new ButtonActionListener());
        settingsButton.addActionListener(new ButtonActionListener());
        helpButton.addActionListener(new ButtonActionListener());
        creditsButton.addActionListener(new ButtonActionListener());

        box.add(playButton);
        box.add(settingsButton);
        box.add(helpButton);
        box.add(creditsButton);

        buttonPanel.add(box);
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

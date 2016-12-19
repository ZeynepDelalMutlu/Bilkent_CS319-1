package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Baris Poyraz on 19.12.2016.
 */
public class GamePanel extends JPanel {

    private CanvasView canvasView;
    private Insets insets;
    private Dimension size;

    private JButton pauseButton;

    private JLabel needScore;
    private JLabel player;
    private JLabel score;

    public GamePanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        pauseButton = buttonDesigner("Pause");
        buttonPlacer(pauseButton, 10+insets.left, 690+insets.top);

        needScore = textDesigner("First to Reach " + ((canvasView.getPlayerNumber()-1)*10), 20);
        textPlacer(needScore, 10+insets.left, 10+insets.top);

        player = textDesigner("Player:", 20);
        textPlacer(player, 10+insets.left, 60+insets.top);

        score = textDesigner("Score:", 20);
        textPlacer(score, 120+insets.left, 60+insets.top);

        game();
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

    private void game(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(new Color(255, 106, 0)));


        panel.setBounds(256 ,0 , 762, 732 );
        add(panel);
    }
    
    private Font font(int size){
        return new Font("Calibri", Font.PLAIN, size);
    }

    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO:PausePanel
        }
    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == pauseButton)
                pauseButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            pauseButton.setForeground(Color.WHITE);
        }
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }
}

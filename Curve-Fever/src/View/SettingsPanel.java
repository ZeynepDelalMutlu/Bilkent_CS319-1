package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Baris Poyraz on 9.12.2016.
 */
public class SettingsPanel extends JPanel {

    private CanvasView canvasView;
    private JButton backButton;
    private JLabel title;
    private JLabel music;
    private Insets insets;
    private Dimension size;

    private JCheckBox checkMusic;

    public SettingsPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);
        insets = super.getInsets();

        backButton = buttonDesigner("Back");
        buttonPlacer(backButton, 940+ insets.left, 690 + insets.top);

        title = textDesigner("Settings");
        textPlacer(title, 470+ insets.left, 80 + insets.top);

        music = textDesigner("Music");
        textPlacer(music, 470 + insets.left, 280 + insets.top);

        checkMusic = new JCheckBox();
        checkMusic.setBackground(Color.BLACK);
        checkMusic.setForeground(Color.BLACK);
        checkMusic.setSelected(true);
        checkMusic.addActionListener(new ButtonActionListener());
        size = checkMusic.getPreferredSize();
        checkMusic.setBounds(440 + insets.left , 285+ insets.top, size.width, size.height );
        add(checkMusic);
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

    private JLabel textDesigner(String text){
        JLabel label = new JLabel(text);
        label.setFont(font());
        label.setForeground(Color.WHITE);
        return label;
    }

    private void textPlacer(JLabel label, int x, int y){
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
            if(e.getSource() == checkMusic){
                if(!checkMusic.isSelected()) {
                    canvasView.getMusicPlay().setDisable();
                }
                else{
                    canvasView.getMusicPlay().setEnable();

                }
            }
        }

    }

    private class ButtonMouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == backButton)
                backButton.setForeground(new Color(47, 165, 255));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            backButton.setForeground(Color.WHITE);
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
    }
}

package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Baris Poyraz on 9.12.2016.
 */
public class HelpPanel extends JPanel {

    private JButton backButton;
    private CanvasView canvasView;

    private Border border;
    private Insets insets;
    private Dimension size;

    public HelpPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);

        buttonDesigner();
    }

    private void buttonDesigner(){
        border = BorderFactory.createEmptyBorder();

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(border);
        backButton.setFont(new Font("Calibri", Font.PLAIN, 30));

        backButton.addActionListener(new ButtonActionListener());

        backButton.addMouseListener(new ButtonMouseListener());
        add(backButton);

        insets = super.getInsets();
        size = backButton.getPreferredSize();
        backButton.setBounds(940+ insets.left, 690 + insets.top, size.width, size.height);
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

package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class CreditsPanel extends JPanel {


    private CanvasView canvasView;
    private JButton backButton;
    private JLabel heading;
    private JLabel credits1;
    private JLabel credits2;
    private JLabel credits3;

    private Border border;
    private Insets insets;
    private Dimension size;

    public CreditsPanel(CanvasView canvasView){
        this.canvasView = canvasView;
        setBackground(Color.BLACK);
        setLayout(null);

        buttonDesigner();
        textDesigner();
    }

    private void buttonDesigner(){

        border = BorderFactory.createEmptyBorder();

        backButton = new JButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(border);
        backButton.setFont(font());

        backButton.addActionListener(new ButtonActionListener());
        backButton.addMouseListener(new ButtonMouseListener());

        add(backButton);

        insets = super.getInsets();
        size = backButton.getPreferredSize();
        backButton.setBounds(940+ insets.left, 690 + insets.top, size.width, size.height);

    }

    public void textDesigner(){
        heading = new JLabel("Credits");
        heading.setFont(font());
        heading.setForeground(Color.WHITE);
        add(heading);

        String text = "This project is a part of CS319" + "\n" + " course in Bilkent University.";
        credits1 = new JLabel("<html>" +text+"</html>");
        credits1.setFont(font());
        credits1.setForeground(Color.WHITE);
        add(credits1);

        String text2 = "<center>Yunus Ölez<br>Barış Poyraz<br>Zeynep Delal Mutlu</center>";
        credits2 = new JLabel("<html>" + text2 +"</html>");
        credits2.setFont(font());
        credits2.setForeground(Color.WHITE);
        add(credits2);

        String text3 = "<center>Special thanks to<br>Bora Güngören</center>";
        credits3 = new JLabel("<html>" + text3 + "</html>");
        credits3.setFont(font());
        credits3.setForeground(Color.WHITE);
        add(credits3);

        insets = super.getInsets();
        size = heading.getPreferredSize();

        heading.setBounds(470+ insets.left, 80 + insets.top, size.width, size.height);

        credits1.setLocation(350, 125);
        credits1.setSize(400,200);

        credits2.setLocation(400,225);
        credits2.setSize(400,300);

        credits3.setLocation(425, 325);
        credits3.setSize(400,400);
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

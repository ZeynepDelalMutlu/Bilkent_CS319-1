package Controller;

import View.CanvasView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 8.12.2016.
 */
public class Controller {

    public static void main(String[] args) {

        CanvasView canvasView = new CanvasView();

        JFrame frame = new JFrame("Curve Fever");

        frame.setPreferredSize(new Dimension(1024,768));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.getContentPane().add(canvasView);
        frame.pack();
        frame.setVisible(true);



    }
}

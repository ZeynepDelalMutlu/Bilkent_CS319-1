package Model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Baris Poyraz on 15.12.2016.
 */
public class Player {

    private String name;
    private Color color;
    private Point point;
    private KeyStroke leftKey;
    private KeyStroke rightKey;


    public Player(String name) {
        this.name = name;
        /*this.color = color;
        this.point = point;
        this.leftKey = leftKey;
        this.rightKey = rightKey;*/
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public String toString(){
        return name;
    }

    public void setLeftKey(KeyStroke leftKey){
        this.leftKey = leftKey;
    }

    public void setRightKey(KeyStroke rightKey){
        this.rightKey = rightKey;
    }

    public KeyStroke getLeftKey(){
        return this.leftKey;
    }

    public KeyStroke getRightKey(){
        return  this.rightKey;
    }
}
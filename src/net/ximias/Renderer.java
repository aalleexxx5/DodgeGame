package net.ximias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Contains the window and a transient a way to get the currently pressed keys.
 * Created by Alex on 01/03/2017.
 */
public class Renderer {
    public static final int GAME_SIZE_X = 500;
    public static final int GAME_SIZE_Y = 500;
    private static ArrayList<String> pressedKeys = new ArrayList<>();
    private JFrame gameFrame;
    private JLabel gameLabel;
    Renderer(){
        gameFrame = new JFrame();
        gameFrame.setUndecorated(true);
        gameFrame.setBounds(0,0,GAME_SIZE_X,GAME_SIZE_Y);
        gameLabel = new JLabel();
        gameLabel.setBounds(gameFrame.getBounds());
        gameFrame.add(gameLabel);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Main.end();
            }
        });
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID()==KeyEvent.KEY_PRESSED){
                    String key = KeyEvent.getKeyText(e.getKeyCode());
                    if (!pressedKeys.contains(key)){
                        pressedKeys.add(key);
                        if (key.equals("Escape")) Game.pause();
                    }
                    return true;
                }else if (e.getID()==KeyEvent.KEY_RELEASED){
                    pressedKeys.remove(KeyEvent.getKeyText(e.getKeyCode()));
                    return true;
                }
                return false;
            }
        });
    }

    public void draw(Image image){
        gameLabel.setIcon(new ImageIcon(image));
    }

    public static ArrayList<String> getPressedKeys(){
        return pressedKeys;
    }

    public void end(){
        gameFrame.dispose();
    }
}

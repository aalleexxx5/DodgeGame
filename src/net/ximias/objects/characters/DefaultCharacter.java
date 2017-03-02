package net.ximias.objects.characters;

import net.ximias.Renderer;

import java.util.ArrayList;

/**
 * Created by Alex on 01/03/2017.
 */
public class DefaultCharacter extends AbstractCharacter {

    public DefaultCharacter(float locationX, float locationY, int size) {
        super(locationX, locationY, size);
    }

    @Override
    void collidesWithXWall() {
    }

    @Override
    void collidesWithYWall() {
    }

    @Override
    public void update() {
        ArrayList<String> keys = Renderer.getPressedKeys();
        for (String key : keys) {
            if (key.equals("Up")) deltaY = -1;
            else if (key.equals("Down")) deltaY = 1;
            else if (key.equals("Left")) deltaX = -1;
            else if (key.equals("Right")) deltaX = 1;
        }
        move();
        deltaX=0;
        deltaY=0;
    }
}

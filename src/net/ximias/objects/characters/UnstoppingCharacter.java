package net.ximias.objects.characters;

import net.ximias.Renderer;

import java.util.ArrayList;

/**
 * A character which does not stop after picking a direction.
 * Created by Alex on 01/03/2017.
 */
public class UnstoppingCharacter extends AbstractCharacter {

    public UnstoppingCharacter(float locationX, float locationY, int size) {
        super(locationX, locationY, size);
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
    }

    @Override
    void collidesWithXWall() {
        deltaX=-deltaX;
    }

    @Override
    void collidesWithYWall() {
        deltaY=-deltaY;
    }
}

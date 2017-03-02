package net.ximias.objects.characters;

import net.ximias.LogicObject;
import net.ximias.Renderer;

import java.awt.*;

/**
 * A Player controlled object. This class was supposed to be abstract..
 * Created by Alex on 01/03/2017.
 */
public abstract class AbstractCharacter implements LogicObject {
    protected float locationX;
    protected float locationY;
    protected int size;
    protected float deltaX;
    protected float deltaY;

    public AbstractCharacter(float locationX, float locationY, int size) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.size = size;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.YELLOW);
        g.fillRect((int)locationX,(int)locationY,size,size);
    }

    protected void move(){
        float newX = locationX + deltaX;
        float newY = locationY + deltaY;
        if (newX<0||newX+size> Renderer.GAME_SIZE_X) {
            collidesWithXWall();
        }
        if (newY<0||newY+size>Renderer.GAME_SIZE_Y) {
            collidesWithYWall();
        }
        locationX=newX;
        locationY=newY;
    }

    abstract void collidesWithXWall();
    abstract void collidesWithYWall();
}

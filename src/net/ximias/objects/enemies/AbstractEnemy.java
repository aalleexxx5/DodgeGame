package net.ximias.objects.enemies;

import net.ximias.LogicObject;

import java.awt.*;

/**
 * Created by Alex on 01/03/2017.
 */
public abstract class AbstractEnemy implements LogicObject {
    protected float locationX;
    protected float locationY;
    protected int size;
    protected float deltaX;
    protected float deltaY;

    public AbstractEnemy(float locationX, float locationY, float deltaX, float deltaY,int size) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.size = size;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect((int)locationX,(int)locationY,size,size);
    }
}

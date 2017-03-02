package net.ximias.objects.enemies;

import net.ximias.Main;

/**
 * An enemy that creates a vanishingEnemy when bouncing on a wall
 * Created by Alex on 02/03/2017.
 */
public class VolatileEnemy extends LinearEnemy {
    public VolatileEnemy(float locationX, float locationY, float deltaX, float deltaY, int size) {
        super(locationX, locationY, deltaX, deltaY, size);
    }
    static final float SIZE_DECREASE_FACTOR = 1.15f;

    @Override
    public void collideWithWallInXDirection() {
        deltaX=-deltaX;
        deltaY = (float) ((Math.random()*3)-1.5);
        size = (int) (size/SIZE_DECREASE_FACTOR);
        if (size<5){
            Main.unregisterObject(this);
        }
        Main.registerObject(new VanishingEnemy(locationX,locationY,(float)(deltaX*(Math.random()+0.5)),(float) ((Math.random()*3)-1.5),size));
    }

    @Override
    public void collideWithWallInYDirection() {
        deltaY = -deltaY;
        deltaX = (float) Math.random()*3;
        size = (int)(size/SIZE_DECREASE_FACTOR);
        if (size<5){
            Main.unregisterObject(this);
        }
        Main.registerObject(new VanishingEnemy(locationX,locationY,(float) ((Math.random()*3)-1.5),(float)(deltaY*(Math.random()+0.5)),size));
    }
}

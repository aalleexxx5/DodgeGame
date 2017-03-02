package net.ximias.objects.enemies;

/**
 * An enemy type that bounces upon hitting a wall
 * Created by Alex on 01/03/2017.
 */
public class BouncingEnemy extends LinearEnemy {
    public BouncingEnemy(float locationX, float locationY, float deltaX, float deltaY, int size) {
        super(locationX, locationY, deltaX, deltaY,size);
    }

    @Override
    public void collideWithWallInXDirection() {
        deltaX=-deltaX;
    }

    @Override
    public void collideWithWallInYDirection() {
        deltaY=-deltaY;
    }
}

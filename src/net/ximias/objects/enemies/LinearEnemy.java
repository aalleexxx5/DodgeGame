package net.ximias.objects.enemies;

import net.ximias.Renderer;

/**
 * Any enemy which continues straight in a single direction
 * Created by Alex on 01/03/2017.
 */
public abstract class LinearEnemy extends AbstractEnemy {
    public LinearEnemy(float locationX, float locationY, float deltaX, float deltaY, int size) {
        super(locationX, locationY, deltaX, deltaY, size);
    }

    @Override
    public void update() {
        locationX+=deltaX;
        locationY+=deltaY;
        if (locationX < 0 || locationX > Renderer.GAME_SIZE_X){
            collideWithWallInXDirection();
        } else if (locationY < 0 || locationY > Renderer.GAME_SIZE_Y){
            collideWithWallInYDirection();
        }
    }

    public abstract void collideWithWallInXDirection();
    public abstract void collideWithWallInYDirection();
}

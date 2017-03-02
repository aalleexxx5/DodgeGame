package net.ximias.objects.enemies;

import net.ximias.Main;

/**
 * An enemy type that vanishes upon colliding with a wall.
 * Created by Alex on 01/03/2017.
 */
public class VanishingEnemy extends LinearEnemy {

    public VanishingEnemy(float locationX, float locationY, float deltaX, float deltaY, int size) {
        super(locationX, locationY, deltaX, deltaY, size);
    }

    @Override
    public void collideWithWallInXDirection() {
        Main.unregisterObject(this);
    }

    @Override
    public void collideWithWallInYDirection() {
        Main.unregisterObject(this);
    }
}

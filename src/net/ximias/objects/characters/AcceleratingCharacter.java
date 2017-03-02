package net.ximias.objects.characters;

import net.ximias.Renderer;

/**
 * Character which accelerates in a direction, when a key is held
 * Created by Alex on 02/03/2017.
 */
public class AcceleratingCharacter extends AbstractCharacter {
    private static final float ACCELERATION_AMOUNT = 0.05f;
    private boolean colliding = false;
    private float collisionDivisor = 1.0f;
    public AcceleratingCharacter(float locationX, float locationY, int size) {
        super(locationX, locationY, size);
    }

    @Override
    void collidesWithXWall() {
        locationX=-deltaX;
        deltaX=-deltaX/collisionDivisor;
    }

    @Override
    void collidesWithYWall() {
        locationY=-deltaY;
        deltaY=-deltaY/collisionDivisor;
    }

    @Override
    public void update() {
        if (Renderer.getPressedKeys().contains("Up"))
            deltaY-=ACCELERATION_AMOUNT;
        else if (Renderer.getPressedKeys().contains("Down")){
            deltaY+=ACCELERATION_AMOUNT;
        }else if (Renderer.getPressedKeys().contains("Left")){
            deltaX-=ACCELERATION_AMOUNT;
        }else if (Renderer.getPressedKeys().contains("Right")){
            deltaX+=ACCELERATION_AMOUNT;
        }
        move();
    }
}

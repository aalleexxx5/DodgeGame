package net.ximias.objects.enemies;

/**
 * Abstract class for any enemy wich has a cooldown timer.
 * Created by Alex on 02/03/2017.
 */
public abstract class LinearCooldownEnemy extends LinearEnemy{
    private int initialCooldown, currentCooldown;
    public LinearCooldownEnemy(float locationX, float locationY, float deltaX, float deltaY, int size, int cooldown) {
        super(locationX, locationY, deltaX, deltaY, size);
        initialCooldown=currentCooldown = cooldown;
    }

    @Override
    public void update() {
        super.update();
        currentCooldown--;
        if (currentCooldown==0){
            action();
        }
    }

    abstract void action();
}

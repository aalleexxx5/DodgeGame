package net.ximias;

import net.ximias.objects.characters.AcceleratingCharacter;
import net.ximias.objects.characters.DefaultCharacter;
import net.ximias.objects.characters.UnstoppingCharacter;
import net.ximias.objects.enemies.BouncingEnemy;
import net.ximias.objects.enemies.VanishingEnemy;
import net.ximias.objects.enemies.VolatileEnemy;
import net.ximias.objects.pauseMenu.PauseMenu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Game loop and a few transient functions
 * Created by Alex on 01/03/2017.
 */
public class Game {
    ArrayList<DrawableObject> drawableObjects = new ArrayList<>();
    ArrayList<LogicObject> logicObjects = new ArrayList<>();
    ArrayList<DrawableObject> toBeRemoved = new ArrayList<>(10);
    ArrayList<DrawableObject> toBeAdded = new ArrayList<>(10);
    Renderer canvas;
    static boolean pause = false;
    PauseMenu pauseMenu;
    Game(){
        //DefaultCharacter charracter = ;
        pauseMenu = new PauseMenu();
        logicObjects.add(new VolatileEnemy(250,250,randomStartingDirection(),randomStartingDirection(),20));
        logicObjects.add(new BouncingEnemy(250,250,randomStartingDirection(),randomStartingDirection(),20));
        logicObjects.add(new VanishingEnemy(250,250,randomStartingDirection(),randomStartingDirection(),20));
        logicObjects.add(new DefaultCharacter(50,50,20));
        canvas = new Renderer();
    }
    private float randomStartingDirection(){
        return (float)(Math.random()*3-1.5);
    }

    void play(){
            BufferedImage bi = new BufferedImage(Renderer.GAME_SIZE_X,Renderer.GAME_SIZE_Y,BufferedImage.TYPE_USHORT_555_RGB);
            Graphics2D g = bi.createGraphics();
            if (pause){
                pauseMenu.draw(g);
                pauseMenu.update();
            }else {
                for (DrawableObject drawableObject : drawableObjects) {
                    drawableObject.draw(g);
                }
                for (LogicObject logicObject : logicObjects) {
                    logicObject.draw(g);
                    logicObject.update();
                }
                removeObjects();
                addObjects();
            }
            canvas.draw(bi);
    }

    public static void pause(){
        pause=true;
    }
    public static void unpause(){
        pause=false;
    }
    public void removeObject(DrawableObject o){
        toBeRemoved.add(o);
    }
    public void addObject(DrawableObject o) {
        toBeAdded.add(o);
    }

    private void removeObjects(){
        for (DrawableObject object : toBeRemoved) {
            drawableObjects.remove(object);
            if (object instanceof LogicObject) {
                logicObjects.remove(object);
            }
        }
        drawableObjects=new ArrayList<>(10);
    }

    private void addObjects(){
        for (DrawableObject object : toBeAdded) {
            if (object instanceof LogicObject) {
                logicObjects.add((LogicObject) object);
            } else {
                drawableObjects.add(object);
            }
        }
        toBeAdded = new ArrayList<>(10);
    }

    void end(){
        canvas.end();
    }
}

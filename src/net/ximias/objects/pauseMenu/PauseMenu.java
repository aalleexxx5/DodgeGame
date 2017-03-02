package net.ximias.objects.pauseMenu;

import net.ximias.LogicObject;
import net.ximias.Renderer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 01/03/2017.
 */
public class PauseMenu implements LogicObject {
    ArrayList<AbstractButton> buttons = new ArrayList<>();
    boolean arrowPressed = false;
    int highlightedButton = 0;
    public PauseMenu(){
        buttons.add(new ResumeButton(100, 20, 300,60,Color.GRAY));
        buttons.add(new OptionsButton(100, 100, 300,60,Color.GRAY));
        buttons.add(new ExitButton(100, 180, 300,60,Color.GRAY));
        buttons.get(highlightedButton).raise();
    }
    @Override
    public void update() {
        if (!arrowPressed){
            if (Renderer.getPressedKeys().contains("Up")){
                arrowPressed=true;
                buttons.get(highlightedButton).lower();
                if (highlightedButton==0) highlightedButton = buttons.size() - 1;
                else highlightedButton--;
                buttons.get(highlightedButton).raise();
            }
            else if (Renderer.getPressedKeys().contains("Down")){
                arrowPressed=true;
                buttons.get(highlightedButton).lower();
                highlightedButton = (highlightedButton + 1)%buttons.size();
                buttons.get(highlightedButton).raise();
            }
        }else{
            if (!Renderer.getPressedKeys().contains("Up")&&!Renderer.getPressedKeys().contains("Down")){
                arrowPressed=false;
            }
        }
        if (Renderer.getPressedKeys().contains("Enter")){
            buttons.get(highlightedButton).onClick();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        for (AbstractButton button : buttons) {
            button.draw(g);
        }
    }
}

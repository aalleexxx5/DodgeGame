package net.ximias.objects.pauseMenu;

import net.ximias.DrawableObject;
import net.ximias.LogicObject;

import java.awt.*;

/**
 * Created by Alex on 01/03/2017.
 */
public abstract class AbstractButton implements DrawableObject {
    protected int locationX, locationY, width, height;
    protected Color color;
    private boolean raised;
    protected String text;
    AbstractButton(int x, int y, int width, int height,String text, Color color){
        locationX = x;
        locationY = y;
        this.width=width;
        this.height=height;
        this.color=color;
        this.text=text;
        raised = false;
    }

    abstract void onClick();

    public void raise(){
        raised = true;
    }

    public void lower(){
        raised=false;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill3DRect(locationX,locationY,width,height,raised);
        g.setColor(Color.WHITE);

        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,height));
        g.drawString(text, (locationX+width/2)-g.getFontMetrics().charsWidth(text.toCharArray(),0,text.length())/2,
                (locationY+height/2)+g.getFontMetrics().getDescent());
    }

}

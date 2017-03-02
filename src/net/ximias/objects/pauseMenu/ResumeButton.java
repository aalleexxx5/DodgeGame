package net.ximias.objects.pauseMenu;

import net.ximias.Game;

import java.awt.*;

/**
 * Created by Alex on 01/03/2017.
 */
public class ResumeButton extends AbstractButton {
    ResumeButton(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,"Resume", color);
    }

    @Override
    void onClick() {
        Game.unpause();
    }

}

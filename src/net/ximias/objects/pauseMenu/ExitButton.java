package net.ximias.objects.pauseMenu;

import net.ximias.Main;

import java.awt.*;

/**
 * Button which exits the game upon being clicked.
 * Created by Alex on 01/03/2017.
 */
public class ExitButton extends AbstractButton {

    ExitButton(int x, int y, int width, int height, Color color) {
        super(x, y, width, height,"Exit", color);
    }

    @Override
    void onClick() {
        Main.end();
    }
}

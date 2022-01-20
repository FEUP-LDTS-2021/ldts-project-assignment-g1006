package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.GameWonMenu;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.viewer.Viewer;

import java.io.IOException;

import static java.lang.Math.round;

public class GameWonViewer extends Viewer<Menu> {
    public GameWonViewer(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public void draw() throws IOException {
        long time = ((GameWonMenu)getModel()).time / 1000;
        String timeStr = String.valueOf(round(time));
        getGui().clear();
        getGui().drawBackground();
        getGui().drawText("YOU DEFEATED THE ALIENS", "#101010", new Position(10,5));
        getGui().drawText("Time:", "#101010", new Position(18,8));
        getGui().drawText(timeStr, "#101010", new Position(24,8));
        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

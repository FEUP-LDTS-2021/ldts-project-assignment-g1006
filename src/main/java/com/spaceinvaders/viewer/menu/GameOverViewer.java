package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.GameOverMenu;
import com.spaceinvaders.model.menu.GameWonMenu;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.viewer.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer<Menu> {
    public GameOverViewer(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public void draw() throws IOException {
        String timeStr = ((GameOverMenu)getModel()).time;
        getGui().clear();
        getGui().drawBackground();
        getGui().drawText("GAME OVER", "#101010", new Position(17,5));
        getGui().drawText("Time:", "#101010", new Position(18,8));
        getGui().drawText(timeStr, "#101010", new Position(24,8));
        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

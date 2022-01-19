package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.viewer.Viewer;

import java.io.IOException;

public class StartMenuViewer extends Viewer<Menu> {
    public StartMenuViewer(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public void draw() throws IOException {
        getGui().clear();
        getGui().drawBackground();
        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

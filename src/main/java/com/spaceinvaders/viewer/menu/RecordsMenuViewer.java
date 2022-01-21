package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.model.menu.RecordsMenu;
import com.spaceinvaders.viewer.Viewer;

import java.io.IOException;
import java.util.Map;

public class RecordsMenuViewer extends Viewer<Menu> {
    public RecordsMenuViewer(Menu model, GUI gui) {
        super(model, gui);
    }

    @Override
    public void draw() throws IOException {
        getGui().clear();
        getGui().drawBackground();
        getGui().drawText("RECORDS TOP 10", "#800000", new Position(15,2));
        getGui().drawText("NAME", "#800000", new Position(7,4));
        getGui().drawText("TIME", "#800000", new Position(35,4));
        int y = 7;
        for (Map.Entry<String, Integer> entry : ((RecordsMenu)getModel()).getEntries()) {
            getGui().drawText(entry.getKey(), "#101010", new Position(7, y));
            getGui().drawText(String.valueOf(entry.getValue()), "#101010", new Position(35, y++));
        }
        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

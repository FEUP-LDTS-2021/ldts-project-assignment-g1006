package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
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
        getGui().drawText("SPACE INVADERS", "#990000", new Position(16,4));

        getGui().drawText("___","#C7BC42", new Position(36,5));
        getGui().drawText("___     ___","#990000", new Position(32,6));
        getGui().drawText("/   \\","#C7BC42", new Position(35,6));
        getGui().drawText("/           \\","#990000", new Position(31,7));
        getGui().drawText("'---'","#C7BC42", new Position(35,7));
        getGui().drawText("'--_______--'","#990000", new Position(31,8));
        getGui().drawText("/ \\","#2FFF24", new Position(36,9));
        getGui().drawText("/   \\","#2FFF24", new Position(35,10));
        getGui().drawText("O","#BF27F2", new Position(37,10));
        getGui().drawText("/     \\","#2FFF24", new Position(34,11));
        getGui().drawText("-|-","#BF27F2", new Position(36,11));
        getGui().drawText("|","#BF27F2", new Position(37,12));
        getGui().drawText("/     \\","#2FFF24", new Position(34,12));
        getGui().drawText("/     \\","#2FFF24", new Position(34,13));
        getGui().drawText("/ \\","#BF27F2", new Position(36,13));

        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

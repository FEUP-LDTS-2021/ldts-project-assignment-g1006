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

        getGui().drawText("/","#990000", new Position(31,7));
        getGui().drawText("'","#990000", new Position(31,8));
        getGui().drawText("-","#990000", new Position(32,8));
        getGui().drawText("-","#990000", new Position(33,8));
        getGui().drawText("_","#990000", new Position(32,6));
        getGui().drawText("_","#990000", new Position(33,6));
        getGui().drawText("_","#990000", new Position(34,6));
        getGui().drawText("/","#C7BC42", new Position(35,6));
        getGui().drawText("'","#C7BC42", new Position(35,7));
        getGui().drawText("-","#C7BC42", new Position(36,7));
        getGui().drawText("-","#C7BC42", new Position(37,7));
        getGui().drawText("-","#C7BC42", new Position(38,7));
        getGui().drawText("'","#C7BC42", new Position(39,7));


        getGui().drawText("_","#C7BC42", new Position(36,5));
        getGui().drawText("_","#C7BC42", new Position(37,5));
        getGui().drawText("_","#C7BC42", new Position(38,5));
        getGui().drawText("\\","#C7BC42", new Position(39,6));
        getGui().drawText("_","#990000", new Position(40,6));
        getGui().drawText("_","#990000", new Position(41,6));
        getGui().drawText("_","#990000", new Position(42,6));
        getGui().drawText("\\","#990000", new Position(43,7));
        getGui().drawText("'","#990000", new Position(43,8));
        getGui().drawText("-","#990000", new Position(42,8));
        getGui().drawText("-","#990000", new Position(41,8));
        getGui().drawText("_","#990000", new Position(40,8));
        getGui().drawText("_","#990000", new Position(39,8));
        getGui().drawText("_","#990000", new Position(38,8));
        getGui().drawText("_","#990000", new Position(37,8));
        getGui().drawText("_","#990000", new Position(36,8));
        getGui().drawText("_","#990000", new Position(35,8));
        getGui().drawText("_","#990000", new Position(34,8));

        getGui().drawText("/","#2FFF24", new Position(36,9));
        getGui().drawText("/","#2FFF24", new Position(35,10));
        getGui().drawText("/","#2FFF24", new Position(34,11));
        getGui().drawText("/","#2FFF24", new Position(34,12));
        getGui().drawText("/","#2FFF24", new Position(34,13));
        getGui().drawText("/","#BF27F2", new Position(36,13));
        getGui().drawText("-","#BF27F2", new Position(38,11));

        getGui().drawText("|","#BF27F2", new Position(37,12));
        getGui().drawText("|","#BF27F2", new Position(37,11));

        getGui().drawText("O","#BF27F2", new Position(37,10));

        getGui().drawText("\\","#2FFF24", new Position(38,9));
        getGui().drawText("\\","#2FFF24", new Position(39,10));
        getGui().drawText("\\","#2FFF24", new Position(40,11));
        getGui().drawText("\\","#2FFF24", new Position(40,12));
        getGui().drawText("\\","#2FFF24", new Position(40,13));
        getGui().drawText("\\","#BF27F2", new Position(38,13));
        getGui().drawText("-","#BF27F2", new Position(36,11));

        for (Button button : getModel().getButtons())
            getGui().drawButton(button);
        getGui().refresh();
    }
}

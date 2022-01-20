package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.GameWonMenu;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class GameWonViewerTest {
    private Viewer<Menu> viewer;
    private Menu menu;
    private GUI gui;

    @BeforeEach
    void setup() {
        this.menu = new GameWonMenu(Mockito.mock(Game.class), 0);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new GameWonViewer(menu, gui);
    }

    @Test
    void drawMenu() throws IOException {
        Button button1 = Mockito.mock(Button.class);
        Button button2 = Mockito.mock(Button.class);
        Button button3 = Mockito.mock(Button.class);
        List<Button> buttons = List.of(button1, button2, button3);

        menu.setButtons(buttons);

        viewer.draw();
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        for (Button button : buttons)
            Mockito.verify(gui, Mockito.times(1)).drawButton(button);
    }
}

package com.spaceinvaders.viewer.menu;

import com.spaceinvaders.Game;
import com.spaceinvaders.RecordsManager;
import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Position;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.model.menu.RecordsMenu;
import com.spaceinvaders.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class RecordsMenuViewerTest {
    private Viewer<Menu> viewer;
    private Menu menu;
    private GUI gui;
    private RecordsManager recordsManager;
    private Game game;

    @BeforeEach
    void setup() {
        this.game = Mockito.mock(Game.class);
        this.recordsManager = Mockito.mock(RecordsManager.class);
        Mockito.when(game.getRecordsManager()).thenReturn(recordsManager);
        this.menu = new RecordsMenu(game);
        this.gui = Mockito.mock(GUI.class);
        this.viewer = new RecordsMenuViewer(menu, gui);
    }

    @Test
    void drawMenu() throws IOException {
        Button button1 = Mockito.mock(Button.class);
        List<Button> buttons = List.of(button1);

        menu.setButtons(buttons);

        viewer.draw();
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
        Mockito.verify(gui, Mockito.times(3)).drawText(Mockito.any(String.class), Mockito.any(String.class), Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        for (Button button : buttons)
            Mockito.verify(gui, Mockito.times(1)).drawButton(button);
    }
}

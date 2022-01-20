package com.spaceinvaders.state;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.model.menu.RecordsMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RecordsMenuStateTest {
    private RecordsMenuState state;
    private Menu menu;
    private GUI gui;

    @BeforeEach
    public void setup() {
        this.menu = Mockito.mock(RecordsMenu.class);
        this.gui = Mockito.mock(GUI.class);
        this.state = new RecordsMenuState(menu,gui);
    }

    @Test
    void getController(){
        Assertions.assertEquals(state.getController().getModel(), state.getModel());
    }
}

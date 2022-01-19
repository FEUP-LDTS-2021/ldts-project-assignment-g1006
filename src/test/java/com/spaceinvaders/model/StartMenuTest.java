package com.spaceinvaders.model;

import com.spaceinvaders.Game;
import com.spaceinvaders.model.menu.Button;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.model.menu.StartMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class StartMenuTest {
    private List<Button> buttons;
    private Game game;
    private Menu menu;

    @BeforeEach
    void setup(){
        this.game = Mockito.mock(Game.class);
        this.menu = new StartMenu(game);
    }

    @Test
    void getGame(){
        Assertions.assertEquals(menu.getGame(), game);
    }

    @Test
    void selectedTest(){
        menu.setSelected(0);
        Assertions.assertEquals(menu.getSelected(), 0);
    }

    @Test
    void buttonsList(){
        Button button1 = Mockito.mock(Button.class);
        buttons = List.of(button1);
        menu.setButtons(buttons);
        Assertions.assertEquals(menu.getButtons(), buttons);
    }

    @Test
    void nextButton(){
        Button button1 = Mockito.mock(Button.class);
        Button button2 = Mockito.mock(Button.class);
        Button button3 = Mockito.mock(Button.class);
        buttons = List.of(button1, button2, button3);
        menu.setButtons(buttons);
        menu.setSelected(0);

        menu.nextButton();
        Assertions.assertEquals(menu.getSelected(), 1);

        menu.nextButton();
        menu.nextButton();
        Assertions.assertEquals(menu.getSelected(), 2);
    }

    @Test
    void previousButton(){
        Button button1 = Mockito.mock(Button.class);
        Button button2 = Mockito.mock(Button.class);
        Button button3 = Mockito.mock(Button.class);
        buttons = List.of(button1, button2, button3);
        menu.setButtons(buttons);
        menu.setSelected(2);

        menu.previousButton();
        Assertions.assertEquals(menu.getSelected(), 1);

        menu.previousButton();
        menu.previousButton();
        Assertions.assertEquals(menu.getSelected(), 0);
    }
}

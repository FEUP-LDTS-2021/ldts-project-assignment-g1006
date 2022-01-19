package state;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.menu.GameOverMenu;
import com.spaceinvaders.model.menu.Menu;
import com.spaceinvaders.state.GameOverState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverStateTest {
    private GameOverState state;
    private Menu menu;
    private GUI gui;

    @BeforeEach
    public void setup() {
        this.menu = Mockito.mock(GameOverMenu.class);
        this.gui = Mockito.mock(GUI.class);
        this.state = new GameOverState(menu,gui);
    }

    @Test
    void getController(){
        Assertions.assertEquals(state.getController().getModel(), state.getModel());
    }
}

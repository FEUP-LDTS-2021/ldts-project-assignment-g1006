package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Button> buttons;
    protected int selected;
    protected Game game;

    public Menu(Game game){
        this.buttons = new ArrayList<>();
        this.game = game;
        this.selected = 0;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Game getGame() {
        return game;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void nextButton(){
        if (selected < buttons.size()-1){
            getButtons().get(selected).setHighlight(false);
            selected++;
            getButtons().get(selected).setHighlight(true);
        }
    }

    public void previousButton(){
        if (selected > 0) {
            getButtons().get(selected).setHighlight(false);
            selected--;
            getButtons().get(selected).setHighlight(true);
        }
    }
}

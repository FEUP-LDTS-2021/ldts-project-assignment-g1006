package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;

import java.util.List;

public abstract class Menu {
    protected List<Button> buttons;
    protected int selected;
    protected Game game;

    public Menu(Game game){
        this.game = game;
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
        if (selected < buttons.size()-1) selected++;
    }

    public void previousButton(){
        if (selected > 0) selected--;
    }
}

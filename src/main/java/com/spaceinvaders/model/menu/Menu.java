package com.spaceinvaders.model.menu;

import com.spaceinvaders.Game;

import java.util.List;

public abstract class Menu {
    protected List<Button> buttons;
    protected int selected;
    protected Game game;

    public Menu(Game game){

    }

    public void setButtons(List<Button> buttons) {

    }

    public List<Button> getButtons() {
        return null;
    }

    public Game getGame() {
        return null;
    }

    public int getSelected() {
        return -1;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void nextButton(){

    }

    public void previousButton(){

    }
}

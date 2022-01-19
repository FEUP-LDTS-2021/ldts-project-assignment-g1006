package com.spaceinvaders.model.menu;

import com.spaceinvaders.controller.command.ButtonCommand;
import com.spaceinvaders.model.Position;

public class Button {
    private final String text;
    private final String color;
    private final Position topleft;
    private final Position bottomright;
    private boolean highlight;
    private ButtonCommand command;

    public Button(String text, String color, Position topleft, Position bottomright){
        this.text = text;
        this.color = color;
        this.topleft = topleft;
        this.bottomright = bottomright;
        this.highlight = false;
    }

    public Position getTopleft() {
        return topleft;
    }

    public Position getBottomright() {
        return bottomright;
    }


    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public boolean isHighlighted(){
        return highlight;
    }

    public void setHighlight(boolean value){
        this.highlight = value;
    }

    public ButtonCommand getCommand() {
        return command;
    }

    public void setCommand(ButtonCommand command) {
        this.command = command;
    }

    public void click(){

    }
}

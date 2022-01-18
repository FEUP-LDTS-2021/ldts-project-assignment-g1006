package com.spaceinvaders.model.menu;

import com.spaceinvaders.model.Position;

public class Button {
    private final String text;
    private final String color;
    private final Position position;
    private final boolean highlight;

    public Button(String text, String color, Position position){
        this.text = text;
        this.color = color;
        this.position = position;
        this.highlight = false;
    }

    public Position getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public boolean getHighlight(){
        return highlight;
    }
}

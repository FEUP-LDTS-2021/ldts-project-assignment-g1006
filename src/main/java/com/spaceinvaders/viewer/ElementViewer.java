package com.spaceinvaders.viewer;

import com.spaceinvaders.gui.GUI;
import com.spaceinvaders.model.Element;

public interface ElementViewer<T extends Element> {
    void drawElement(T element, GUI gui);
}

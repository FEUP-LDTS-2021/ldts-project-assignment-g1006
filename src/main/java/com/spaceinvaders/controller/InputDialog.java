package com.spaceinvaders.controller;

import javax.swing.*;

public class InputDialog {
    private final String name;

    public InputDialog() {
        JFrame f = new JFrame();
        name = JOptionPane.showInputDialog(f, "Enter Name");
        f.dispose();
    }

    public String getString() {
        return this.name;
    }
}

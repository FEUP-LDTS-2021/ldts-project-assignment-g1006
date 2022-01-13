package com.spaceinvaders

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import spock.lang.Specification

class AmmoSpockTest extends Specification{
    private Screen screen

    def setup(){
        def terminalSize = new TerminalSize(20, 20)
        def terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
        def terminal = terminalFactory.createTerminal()
        Screen screen = new TerminalScreen(terminal)
        this.screen = screen
    }

    def "ammo up movement"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, -1, 0)

        when:
        ammo.move()

        then:
        ammo.getPosition() == new Position(10,19)
    }

    def "ammo down movement"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, 1, 0)

        when:
        ammo.move()

        then:
        ammo.getPosition() == new Position(10,21)
    }

    def "draw ammo character"(){
        given:
        def ammo = new Ammo(10,10, '|' as char, 0, 0)

        when:
        ammo.draw(screen.newTextGraphics())

        then:
        screen.getBackCharacter(10,10).getCharacter() == ammo.getCharacter()
    }
}
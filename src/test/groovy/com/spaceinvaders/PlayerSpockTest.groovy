package com.spaceinvaders

import com.spaceinvaders.model.Player
import com.spaceinvaders.model.Position
import spock.lang.Specification

class PlayerSpockTest extends Specification{

    def "player constructor"(){
        given:
        def player = new Player(10,20,'P' as char)

        expect:
        player.getPosition() == new Position(10,20)
    }

    def "player gets"(){
        given:
        def player = new Player(10,20,'P' as char)

        when:
        def position = player.getPosition()

        then:
        position == new Position(10,20)
    }

    def "player sets"(){
        given:
        def player = new Player(10,20,'P' as char)

        when:
        player.setPosition(new Position(1,1))

        then:
        player.getPosition() == new Position(1,1)
    }
}
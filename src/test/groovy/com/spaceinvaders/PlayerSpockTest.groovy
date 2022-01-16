package com.spaceinvaders

import com.spaceinvaders.model.Arena
import com.spaceinvaders.model.Player
import com.spaceinvaders.model.Position
import spock.lang.Specification

class PlayerSpockTest extends Specification{
    private Arena arena

    def setup(){
        this.arena = Mock(Arena.class)
    }

    def "player movement"(){
        given:
        def player = new Player(10,20,'P' as char)
        arena.getWidth() >> 20

        when:
        player.moveLeft(arena)

        then:
        player.getPosition().getX() == 9
        player.getPosition().getY() == 20

        when:
        player.moveRight(arena)

        then:
        player.getPosition().getX() == 10
        player.getPosition().getY() == 20
    }

    def "player movement outside of the arena (left side)"(){
        given:
        def player = new Player(0,20,'P' as char)

        when:
        player.moveLeft(arena);

        then:
        player.getPosition() == new Position(0,20)
    }

    def "player movement outside of the arena (right side)"(){
        given:
        def player = new Player(19,20,'P' as char)
        arena.getWidth() >> 20

        when:
        player.moveRight(arena);

        then:
        player.getPosition() == new Position(19,20)
    }

    def "player shoots"(){
        given:
        def arena1 = new Arena(20,20)
        arena1.setProjectiles([])
        def player = new Player(10,10, 'P' as char)

        when:
        player.shoot(arena1)

        then:
        arena1.getProjectiles()[0].getPosition().getX() == player.getPosition().getX()
        arena1.getProjectiles()[0].getPosition().getY() == player.getPosition().getY() - 1
    }
}
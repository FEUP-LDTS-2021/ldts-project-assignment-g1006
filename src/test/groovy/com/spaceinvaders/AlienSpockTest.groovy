package com.spaceinvaders

import com.spaceinvaders.model.Alien
import com.spaceinvaders.model.Arena
import spock.lang.Specification

class AlienSpockTest extends Specification{
    private Arena arena

    def setup(){
        this.arena = Mock(Arena.class)
    }

    def "change alien movement direction"(){
        given:
        def alien = new Alien(10,10, 'A' as char)

        when:
        alien.changeDirection()

        then:
        alien.getDirection() == -1
    }

    /*
    def "test if there is an alien below"(){
        given:
        def alien1 = new com.spaceinvaders.model.Alien(10,10,'A' as char)
        def alien2 = new com.spaceinvaders.model.Alien(10,11,'A' as char)
        def arena = Mock(com.spaceinvaders.model.Arena.class)
        arena.getAliens() >> [alien1, alien2]

        expect:
        !alien1.freeToShoot(arena)

    }

    def "test if there is an alien below in the same column"(){
        given:
        def alien1 = new com.spaceinvaders.model.Alien(10,10,'A' as char)
        def alien2 = new com.spaceinvaders.model.Alien(10,19,'A' as char)
        def arena = Mock(com.spaceinvaders.model.Arena.class)
        arena.getAliens() >> [alien1, alien2]

        expect:
        !alien1.freeToShoot(arena)

    }

    def "test if there isn't any alien below"(){
        given:
        def alien1 = new com.spaceinvaders.model.Alien(10,10,'A' as char)
        def alien2 = new com.spaceinvaders.model.Alien(11,12,'A' as char)
        def arena = Mock(com.spaceinvaders.model.Arena.class)
        arena.getAliens() >> [alien1, alien2]

        expect:
        alien1.freeToShoot(arena)

    }


    def "test alien shooting above another one"(){
        given:
        def alien1 = new com.spaceinvaders.model.Alien(10,10,'A' as char)
        def alien2 = new com.spaceinvaders.model.Alien(10,12,'A' as char)
        arena.setAliens([alien2, alien1])
        arena.setProjectiles([])
        alien1.freeToShoot(arena) >> false

        when:
        alien1.shoot(arena)

        then:
        arena.getProjectiles().isEmpty()
    }

    def "test alien shooting below another one"() {
        given:
        def alien1 = new com.spaceinvaders.model.Alien(10, 10, 'A' as char)
        def alien2 = new com.spaceinvaders.model.Alien(10, 12, 'A' as char)
        alien2.freeToShoot(arena) >> true
        arena.setAliens([alien1, alien2])
        arena.setProjectiles([])

        when:
        alien2.shoot(arena)

        then:
        arena.getProjectiles()[0].getPosition() == new com.spaceinvaders.model.Position(10,13)
    }
    */
}

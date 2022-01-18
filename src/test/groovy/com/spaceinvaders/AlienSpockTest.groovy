package com.spaceinvaders

import com.spaceinvaders.model.Alien
import com.spaceinvaders.model.Ammo
import com.spaceinvaders.model.Arena
import com.spaceinvaders.model.ArmoredAlienStrategy
import com.spaceinvaders.model.NormalAlienStrategy
import spock.lang.Specification

class AlienSpockTest extends Specification{
    private Arena arena

    def setup(){
        this.arena = Mock(Arena.class)
    }

    def "change alien movement direction"(){
        given:
        def alien = new Alien(10,10, 'A' as char,0)

        when:
        alien.changeDirection()

        then:
        alien.getDirection() == -1
    }

    def "alien strategy test"(){
        given:
        def alien1 = new Alien(10,10, 'A' as char,0)
        def alien2 = new Alien(10,10, 'A' as char,1)

        when:
        def strategy = alien1.getStrategy()

        then:
        strategy instanceof NormalAlienStrategy

        when:
        strategy = alien2.getStrategy()

        then:
        strategy instanceof ArmoredAlienStrategy
    }

    def "alien change strategy test"(){
        given:
        def alien1 = new Alien(10,10, 'A' as char,0)

        when:
        def strategy = alien1.getStrategy()

        then:
        strategy instanceof NormalAlienStrategy

        when:
        alien1.setArmor(1)
        strategy = alien1.getStrategy()

        then:
        strategy instanceof ArmoredAlienStrategy
    }

    def "alien test if dead"(){
        given:
        def alien = new Alien(10,10,'A' as char,1)

        expect:
        !alien.isDead()

        when:
        alien.setArmor(0)

        then:
        !alien.isDead()

        when:
        alien.setArmor(-1)

        then:
        alien.isDead()
    }

    def "handle shot test"(){
        given:
        def alien = new Alien(10,10,'A' as char, 2)
        def ammo = new Ammo(10,10,'|' as char, -1,1)

        when:
        alien.handleShot(ammo)

        then:
        alien.getArmor() == 1
        ammo.getDirection() == 1
        !alien.isDead()

        when:
        alien.setArmor(0)
        ammo.setDirection(-1)
        alien.handleShot(ammo)

        then:
        alien.isDead()
        ammo.getDirection() == -1
    }

    def "handle shot bullets passing through test"(){
        given:
        def alien = new Alien(12,12,'A' as char, 0)
        def ammo = new Ammo(12,12,'|' as char, -1, 2)

        when:
        alien.handleShot(ammo)

        then:
        alien.isDead()
        ammo.getDirection() == -1
        ammo.getDamage() == 1

        when:
        alien.setArmor(0)
        alien.handleShot(ammo)

        then:
        alien.isDead()
        ammo.getDamage() == 0

        when:
        ammo.setDamage(4)

        and:
        alien.setArmor(2)
        alien.handleShot(ammo)

        then:
        alien.isDead()
        ammo.getDirection() == -1
        ammo.getDamage() == 1

        when:
        alien.setArmor(1)
        alien.handleShot(ammo)

        then:
        alien.getArmor() == 0
        ammo.getDamage() == 1
        ammo.getDirection() == 1
    }

    def "alien test if alive"(){
        given:
        def alien = new Alien(10,10,'A' as char,1)

        when:
        alien.setArmor(-1)

        then:
        alien.isDead()

        when:
        alien.setArmor(0)

        then:
        !alien.isDead()
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

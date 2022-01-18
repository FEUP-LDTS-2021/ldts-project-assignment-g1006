package com.spaceinvaders

import com.spaceinvaders.model.Ammo
import com.spaceinvaders.model.Position
import spock.lang.Specification

class AmmoSpockTest extends Specification{

    def "ammo getPosition"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, -1, 0)

        expect:
        ammo.getPosition() == new Position(10,20)
    }

    def "ammo setPosition"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, 1, 0)

        when:
        ammo.setPosition(new Position(1,1))

        then:
        ammo.getPosition() == new Position(1,1)
    }

    def "ammo getDamage"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, -1, 0)

        expect:
        ammo.getDamage() == 0
    }

    def "ammo setDamage"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, 1, 0)

        when:
        ammo.setDamage(1)

        then:
        ammo.getDamage() == 1
    }

    def "ammo getDirection"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, -1, 0)

        expect:
        ammo.getDirection() == -1
    }

    def "ammo setDirection"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, -1, 0)

        when:
        ammo.setDirection(1)

        then:
        ammo.getDirection() == 1
    }
}
package com.spaceinvaders

import com.spaceinvaders.model.Ammo
import com.spaceinvaders.model.Position
import spock.lang.Specification

class AmmoSpockTest extends Specification{

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
}
import spock.lang.Specification

class AlienSpockTest extends Specification{
    def "alien movement"(){
        given:
        def alien = new Alien(10,20,'A' as char)

        when:
        def position1 = alien.moveLeft()
        def position2 = alien.moveRight()

        then:
        position1.getX() == 9
        position1.getY() == 20
        position2.getX() == 11
        position2.getY() == 20
    }
}


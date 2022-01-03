import spock.lang.Specification

class PlayerSpockTest extends Specification{
    def "player movement"(){
        given:
        def player = new Player(10,20)

        when:
        def position1 = player.moveLeft()
        def position2 = player.moveRight()

        then:
        position1.getX() == 9
        position1.getY() == 20
        position2.getX() == 11
        position2.getY() == 20
    }
}

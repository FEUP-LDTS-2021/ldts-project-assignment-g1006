import spock.lang.Specification

class PositionSpockTest extends Specification{
    def "same position objects"(){
        given:
        def p1 = new Position(2,3)
        def p2 = new Position(2,3)

        expect:
        p1 == p2
    }
}

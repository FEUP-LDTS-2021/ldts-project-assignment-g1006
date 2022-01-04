import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class AlienSpockTest extends Specification{
    private Screen screen

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

    def "draw alien character"(){
        given:
        def alien = new Alien(10,10, 'A' as char)

        when:
        alien.draw(screen.newTextGraphics())

        then:
        screen.getBackCharacter(10,10).getCharacter() == alien.getCharacter()
    }
}


import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class AlienSpockTest extends Specification{
    private Screen screen

    def setup(){
        def terminalSize = new TerminalSize(20, 20)
        def terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
        def terminal = terminalFactory.createTerminal()
        Screen screen = new TerminalScreen(terminal)
        this.screen = screen
    }

    def "alien movement"(){
        given:
        def alien = new Alien(10,20,'A' as char)

        when:
        alien.move()

        then:
        alien.getPosition() == new Position(11,20);

        when:
        alien.move()

        then:
        alien.getPosition() == new Position(12,20);
    }

    def "change alien movement direction"(){
        given:
        def alien = new Alien(10,10, 'A' as char)

        when:
        alien.changeDirection()

        then:
        alien.getDirection() == -1
    }

    def "alien movement decision"(){
        given:
        def alien = new Alien(10,10, 'A' as char)

        when:
        alien.move()

        then:
        alien.getPosition() == new Position(11,10);

        when:
        alien.changeDirection()
        alien.move()
        alien.move()

        then:
        alien.getPosition() == new Position(9,10);
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


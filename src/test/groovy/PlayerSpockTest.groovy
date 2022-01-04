import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class PlayerSpockTest extends Specification{
    private Screen screen

    def setup(){
        def terminalSize = new TerminalSize(20, 20)
        def terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
        def terminal = terminalFactory.createTerminal()
        Screen screen = new TerminalScreen(terminal)
        this.screen = screen
    }

    def "player movement"(){
        given:
        def player = new Player(10,20,'P' as char)

        when:
        player.moveLeft()

        then:
        player.getPosition().getX() == 9
        player.getPosition().getY() == 20

        when:
        player.moveRight()

        then:
        player.getPosition().getX() == 10
        player.getPosition().getY() == 20
    }

    def "draw player character"(){
        given:
        def player = new Player(10,10, 'P' as char)

        when:
        player.draw(screen.newTextGraphics())

        then:
        screen.getBackCharacter(10,10).getCharacter() == player.getCharacter()
    }
}

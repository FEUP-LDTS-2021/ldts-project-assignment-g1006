import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class PlayerSpockTest extends Specification{
    private Screen screen
    private Arena arena

    def setup(){
        def terminalSize = new TerminalSize(20, 20)
        def terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
        def terminal = terminalFactory.createTerminal()
        Screen screen = new TerminalScreen(terminal)
        this.screen = screen
        this.arena = Mock(Arena.class)
    }

    def "player movement"(){
        given:
        def player = new Player(10,20,'P' as char)
        arena.getWidth() >> 20

        when:
        player.moveLeft(arena)

        then:
        player.getPosition().getX() == 9
        player.getPosition().getY() == 20

        when:
        player.moveRight(arena)

        then:
        player.getPosition().getX() == 10
        player.getPosition().getY() == 20
    }

    def "player shoots"(){
        given:
        def arena1 = new Arena(20,20)
        arena1.setProjectiles([])
        def player = new Player(10,10, 'P' as char)

        when:
        player.shoot(arena1)

        then:
        arena1.getProjectiles()[0].getPosition().getX() == player.getPosition().getX()
        arena1.getProjectiles()[0].getPosition().getY() == player.getPosition().getY() - 1
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

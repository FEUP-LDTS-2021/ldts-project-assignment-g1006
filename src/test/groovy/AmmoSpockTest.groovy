import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class AmmoSpockTest extends Specification{
    private Screen screen

    def setup(){
        def terminalSize = new TerminalSize(20, 20)
        def terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize)
        def terminal = terminalFactory.createTerminal()
        Screen screen = new TerminalScreen(terminal)
        this.screen = screen
    }

    def "ammo movement"(){
        given:
        def ammo = new Ammo(10,20,'B' as char, 0, 0)

        when:
        ammo.moveUp()

        then:
        ammo.getPosition().getX() == 10
        ammo.getPosition().getY() == 19

        when:
        ammo.moveDown()

        then:
        ammo.getPosition().getX() == 10
        ammo.getPosition().getY() == 20
    }

    def "draw ammo character"(){
        given:
        def ammo = new Ammo(10,10, 'B' as char, 0, 0)

        when:
        ammo.draw(screen.newTextGraphics())

        then:
        screen.getBackCharacter(10,10).getCharacter() == ammo.getCharacter()
    }
}
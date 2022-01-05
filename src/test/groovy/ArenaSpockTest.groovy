import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.mockito.Mockito
import spock.lang.Specification

class ArenaSpockTest extends Specification{
    def "alien and walls collisions"(){
        given:
        def arena = new Arena(40, 20)
        def alien = new Alien(40,4,'A' as char)

        when:
        def aliens = [alien]
        arena.setAliens(aliens)

        then:
        arena.checkAlienLimitsCollisions()
    }
}

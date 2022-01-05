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

    def "alien and projectiles collisions"(){
        given:
        def arena = new Arena(40, 20)
        def alien = new Alien(10,4,'A' as char)
        def ammo = new Ammo(10, 4, 'B' as char, -1, 1)

        when:
        def aliens = [alien]
        def projectiles = [ammo]
        arena.setAliens(aliens)
        arena.setProjectiles(projectiles)
        arena.checkAlienProjectilesCollisions()

        then:
        !aliens.contains(alien)
        !projectiles.contains(ammo)
    }
}

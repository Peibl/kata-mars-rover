import domain.Orientations
import domain.Position
import domain.Plateau
import org.junit.Test
import kotlin.test.assertEquals

class RoverTest {
    private val SOME_POSITION = Position(5, 2)
    private val SOME_ORIENTATION = Orientations.WEST
    private val SOME_ORIENTATION_ROTATED_LEFT = Orientations.SOUTH
    private val SOME_ORIENTATION_ROTATED_RIGHT = Orientations.NORTH
    private val NEXT_POSITION_SAME_ORIENTATION = Position(4, 2)
    private val PREVIOUS_POSITION_SAME_ORIENTATION = Position(6, 2)
    private val ENOUGH_WIDTH = 10
    private val ENOUGH_HEIGHT = 10

    // cuando se mueven las posiciones, la posicion es inmutable, con lo cual no deberíamos cambiarla sino crear una posicion nueva (new Position())

    @Test
    fun `Forward command increments position in 1 in the same orientation`() {
        val plateau = Plateau(ENOUGH_WIDTH, ENOUGH_HEIGHT)
        val rover = plateau.registerRoverAt(SOME_POSITION, SOME_ORIENTATION)

        rover.execute("F")

        assertEquals(NEXT_POSITION_SAME_ORIENTATION, rover.position)
    }

    @Test
    fun `Backward command decrements position in 1 in the same orientation`() {
        val plateau = Plateau(ENOUGH_WIDTH, ENOUGH_HEIGHT)
        val rover = plateau.registerRoverAt(SOME_POSITION, SOME_ORIENTATION)

        rover.execute("B")

        assertEquals(PREVIOUS_POSITION_SAME_ORIENTATION, rover.position)
    }

    @Test
    fun `Left command changes rover orientation to left`() {
        val plateau = Plateau(ENOUGH_WIDTH, ENOUGH_HEIGHT)
        val rover = plateau.registerRoverAt(SOME_POSITION, SOME_ORIENTATION)

        rover.execute("L")

        assertEquals(SOME_ORIENTATION_ROTATED_LEFT, rover.orientation)
    }

    @Test
    fun `Right command changes rover orientation to right`() {
        val plateau = Plateau(ENOUGH_WIDTH, ENOUGH_HEIGHT)
        val rover = plateau.registerRoverAt(SOME_POSITION, SOME_ORIENTATION)

        rover.execute("R")

        assertEquals(SOME_ORIENTATION_ROTATED_RIGHT, rover.orientation)
    }
}
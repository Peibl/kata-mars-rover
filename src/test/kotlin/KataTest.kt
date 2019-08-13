import domain.Coordinates
import domain.Rover
import org.junit.Test
import kotlin.test.assertEquals

class KataTest {
    @Test
    fun `sarasa`() {
        val coordinates = Coordinates()
        val rover = Rover(coordinates, "N")

        rover.execute("F")

        assertEquals(coordinates.nextPositionToNorth(), rover.getPosition())
    }}

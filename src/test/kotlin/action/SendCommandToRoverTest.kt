package action

import org.junit.Assert
import org.junit.Test
import RoversInMemory
import domain.Plateau
import infrastructure.RoverBuilder.Companion.aRover

class SendCommandToRoverTest {

    @Test
    fun `move it forward one position when an F command is sent`() {
        val rover = aRover().id(SOME_ROVER_ID).build()
        val rovers = RoversInMemory()
        rovers.add(rover)
        val plateau = Plateau(SOME_SIZE)
        val result = SendCommandToRover(rovers, plateau).execute(SOME_ROVER_ID, "F")

        Assert.assertEquals("01NOK", result)
    }


    @Test
    fun `stop moving when obstacle found`() {

    }

    private val SOME_SIZE = 2
    private val SOME_ROVER_ID = 1
}

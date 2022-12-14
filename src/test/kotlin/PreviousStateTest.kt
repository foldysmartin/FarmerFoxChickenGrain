import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PreviousStateTest {

    @Test
    fun endStateReturnsPreviousState() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.RIGHT, Position.RIGHT);
        val previousState = mapOf(Moves.ChickenLeft to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT))
        assertEquals(previousState, state.potentialMoves() )
    }

    @Test
    fun canReturnMultipleStates() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.LEFT, Position.RIGHT);
        val expectedStates = mapOf(
            Moves.FarmerLeft to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT),
            Moves.FoxLeft to State(Position.LEFT, Position.LEFT, Position.LEFT, Position.RIGHT),
            Moves.GrainLeft to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.LEFT),
        )
        assertEquals(expectedStates, state.potentialMoves())
    }
}
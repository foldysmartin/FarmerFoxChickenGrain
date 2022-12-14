import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class PreviousStateTest {

    @Test
    fun endStateReturnsPreviousState() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.RIGHT, Position.RIGHT)
        val previousState = mapOf(Moves.Chicken to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT))
        assertEquals(previousState, state.potentialMoves() )
    }

    @Test
    fun canReturnMultipleStates() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.LEFT, Position.RIGHT)
        val expectedStates = mapOf(
            Moves.Farmer to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.RIGHT),
            Moves.Fox to State(Position.LEFT, Position.LEFT, Position.LEFT, Position.RIGHT),
            Moves.Grain to State(Position.LEFT, Position.RIGHT, Position.LEFT, Position.LEFT),
        )
        assertEquals(expectedStates, state.potentialMoves())
    }

    @Test
    fun cannotMoveFromAnInvalidState() {
        val state = State(Position.RIGHT, Position.LEFT, Position.LEFT, Position.RIGHT)
        assertThrows<IllegalStateException> {  state.potentialMoves () }
    }
}
import org.junit.jupiter.api.Test

internal class StateValidationTest {

    @Test
    fun startingStateIsValid() {
        val state = State(Position.LEFT, Position.LEFT, Position.LEFT, Position.LEFT);
        assert(state.isValid())
    }

    @Test
    fun endStateIsValid() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.RIGHT, Position.RIGHT);
        assert(state.isValid())
    }

    @Test
    fun stateCannotContainInvalidPosition() {
        val state = State(Position.INVALID, Position.RIGHT, Position.RIGHT, Position.RIGHT);
        assert(!state.isValid())
    }

    @Test
    fun chickenAndFoxCannotBeAlone() {
        val state = State(Position.RIGHT, Position.LEFT, Position.LEFT, Position.RIGHT)
        assert(!state.isValid())
    }

    @Test
    fun chickenAndGrainCannotBeAlone() {
        val state = State(Position.RIGHT, Position.RIGHT, Position.LEFT, Position.LEFT)
        assert(!state.isValid())
    }
}
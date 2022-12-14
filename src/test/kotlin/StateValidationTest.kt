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
        val state = State(Position.RIVER, Position.LEFT, Position.LEFT, Position.RIVER)
        assert(!state.isValid())
    }

    @Test
    fun chickenAndGrainCannotBeAlone() {
        val state = State(Position.RIVER, Position.RIVER, Position.LEFT, Position.LEFT)
        assert(!state.isValid())
    }

    @Test
    fun chickenMustNotBeWithoutTheFarmerInTheRiver() {
        val state = State(Position.LEFT, Position.LEFT, Position.RIVER, Position.LEFT)
        assert(!state.isValid())
    }

    @Test
    fun farmerCanOnlyCarryOneItem() {
        val state = State(Position.RIVER, Position.RIVER, Position.RIVER, Position.LEFT)
        assert(!state.isValid())
    }
}
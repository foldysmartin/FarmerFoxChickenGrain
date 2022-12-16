import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class FindPathTests {
    @Test
    fun findPathAlwaysReturnsAResult() {
        var startingState = State(farmer = Position.LEFT, fox = Position.LEFT, chicken = Position.LEFT, grain = Position.LEFT)
        val endState = State(farmer = Position.RIGHT, fox = Position.RIGHT, chicken = Position.RIGHT, grain = Position.RIGHT)

        repeat(100000) {
            assertEquals(PathFinder(startingState, endState).findPath().size, 7);
        }
    }
}
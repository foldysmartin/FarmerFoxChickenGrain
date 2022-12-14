enum class Position {
    LEFT,
    RIVER,
    RIGHT,
    INVALID;

    fun moveLeft() = if (this.isRight()) RIVER else if (this.isInRiver()) LEFT else INVALID
    fun moveRight() = if (this.isLeft()) RIVER else if (this.isInRiver()) RIGHT else INVALID
    fun isInRiver() = this == RIVER
    fun isInvalid() = this == INVALID
    private fun isLeft() = this == LEFT
    private fun isRight() = this == RIGHT
}
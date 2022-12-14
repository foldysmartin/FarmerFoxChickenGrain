enum class Position {
    LEFT,
    RIGHT,
    INVALID;

    fun moveLeft() = if (this.isRight()) LEFT else INVALID
    fun moveRight() = if (this.isLeft())  RIGHT else INVALID
    fun isInvalid() = this == INVALID
    private fun isLeft() = this == LEFT
    private fun isRight() = this == RIGHT
}
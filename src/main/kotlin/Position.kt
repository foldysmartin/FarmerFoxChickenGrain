enum class Position {
    LEFT,
    RIGHT;

    fun move() = if (this.isRight()) LEFT else RIGHT
    private fun isRight() = this == RIGHT
}
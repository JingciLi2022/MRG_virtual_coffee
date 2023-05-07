class Person(
    val name: String,
    val email: String,
    val team: String) {
    override fun toString(): String = "name: $name, email: $email, team: $team"
}
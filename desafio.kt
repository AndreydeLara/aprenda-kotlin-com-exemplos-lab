enum class Level { BASIC, INTERMEDIATE, HARD }

data class User(val name: String)

data class EducationalContent(
    val name: String,
    val duration: Int = 60
)

data class Training(
    val name: String,
    val level: Level,
    val contents: List<EducationalContent>
) {
    private val enrolledUsers = mutableListOf<User>()

    fun enroll(user: User) {
        if (enrolledUsers.contains(user)) {
            println("Usuário ${user.name} já está matriculado na formação $name.")
        } else {
            enrolledUsers.add(user)
            println("Usuário ${user.name} matriculado com sucesso na formação $name.")
        }
    }

    fun listEnrolledUsers() {
        if (enrolledUsers.isEmpty()) {
            println("Nenhum usuário matriculado na formação $name.")
        } else {
            println("Usuários matriculados na formação $name:")
            enrolledUsers.forEach { println("- ${it.name}") }
        }
    }
}

fun main() {
    val kotlinBasics = EducationalContent("Introdução ao Kotlin", 120)
    val advancedKotlin = EducationalContent("Kotlin Avançado", 180)
    val cleanCode = EducationalContent("Princípios de Clean Code", 90)

    val kotlinTraining = Training(
        name = "Formação Kotlin Developer",
        level = Level.INTERMEDIATE,
        contents = listOf(kotlinBasics, advancedKotlin)
    )

    val cleanCodeTraining = Training(
        name = "Formação Clean Code",
        level = Level.HARD,
        contents = listOf(cleanCode)
    )

    val alice = User("Alice")
    val bob = User("Bob")
    val carol = User("Carol")

    kotlinTraining.enroll(alice)
    kotlinTraining.enroll(bob)

    cleanCodeTraining.enroll(carol)
    cleanCodeTraining.enroll(alice)

    kotlinTraining.listEnrolledUsers()
    cleanCodeTraining.listEnrolledUsers()
}

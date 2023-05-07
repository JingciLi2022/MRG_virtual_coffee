import java.io.InputStream
import java.io.OutputStream

object CsvParser {
    fun readCsv(inputStream: InputStream): List<Person> {
        val reader = inputStream.bufferedReader()
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (name, email, team) = it.split(',', ignoreCase = false, limit = 3)
                Person(name, email, team)
            }.toList()
    }

    fun writeCsv(outputStream: OutputStream, p1ToP2: Map<Person, Person>) {
        val writer = outputStream.bufferedWriter()
        writer.write("""First Team Member, Email, Team, Second Team Member, Email, Team""")
        writer.newLine()
        p1ToP2.forEach {
            writer.write("${it.key.name}, ${it.key.email}, ${it.key.team}, ${it.value.name}, ${it.value.email}, ${it.value.team}")
            writer.newLine()
        }
        writer.flush()
    }

}
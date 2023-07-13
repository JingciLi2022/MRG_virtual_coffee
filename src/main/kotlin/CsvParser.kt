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

    /**
     * Read only email fields of history/blacklist file
     */
    fun readCsvDoubleColumn(inputStream: InputStream): Set<Pair<String, String>> {
        val reader = inputStream.bufferedReader()
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (_, email1, _, _, email2, _) = it.split(',', ignoreCase = false, limit = 6)
                Pair(email1, email2)
            }.toSet()

    }
}

private operator fun <E> List<E>.component6(): E  = this[6]

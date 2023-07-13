import java.io.File
import java.io.SequenceInputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.util.*


fun main() {
    val path = Paths.get("").toAbsolutePath().toString()

    // member info
    val memberFile = Files.newInputStream(Paths.get("$path/input/MRG_members.csv"))

    // blacklist
    val blackListFile = Files.newInputStream(Paths.get("$path/input/Blacklist.csv"))

    // history
    val historyFiles = SequenceInputStream(Collections.enumeration(
        File("$path/input/history")
            .walkTopDown()
            .filter { it.isFile }
            .map { Files.newInputStream(it.toPath()) }
            .toList()
    ))


    val members = CsvParser.readCsv(memberFile)
    val blackList = CsvParser.readCsvDoubleColumn(SequenceInputStream(historyFiles, blackListFile))

    val pairs = PairMaker.makePairs(members, blackList)


    // stream out to a csv file of match info
    val date = LocalDate.now()
    val outputStream = Files.newOutputStream(Paths.get("$path/output/MRG_match_$date.csv"))

    CsvParser.writeCsv(outputStream, pairs)
}




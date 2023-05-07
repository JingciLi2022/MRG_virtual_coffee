import java.nio.file.Files
import java.nio.file.Paths


fun main() {
    val path = Paths.get("").toAbsolutePath().toString()
    // stream in a csv file of member info
    val inputStream = Files.newInputStream(Paths.get("$path/MRG_members.csv"))
    val p1ToP2 = PairMaker.makePairs(CsvParser.readCsv(inputStream))
    // stream out to a csv file of match info
    val outputStream = Files.newOutputStream(Paths.get("$path/MRG_match.csv"))
    CsvParser.writeCsv(outputStream, p1ToP2)
}




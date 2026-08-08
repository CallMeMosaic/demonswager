package GlobalFunctions

/**
 * Base: Rank by Size
 * Factors: Extension, Name,
 */
import java.io.File

interface FileRanking {
    val levelOneExtensions: List<String>
    val levelTwoExtensions: List<String>
    val levelThreeExtensions: List<String>
    val levelFourExtensions: List<String>
    val levelFiveExtensions: List<String>

    var returnValue: Double

    fun rankByExtension(file: File): Double {
        when {
            file.extension in levelOneExtensions -> return returnValue * 1.0
            file.extension in levelTwoExtensions -> return returnValue * 1.2
            file.extension in levelThreeExtensions -> return returnValue * 1.5
            file.extension in levelFourExtensions -> return returnValue * 1.7
            file.extension in levelFiveExtensions -> return returnValue * 2.0
            else -> return returnValue * 1
        }
    }

    fun rankBySize(file: File):Double{
        returnValue = file.length().toDouble() * 0.000001
        return returnValue
    }

}
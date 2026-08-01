package GlobalFunctions

import java.io.File

object RootPath {
    val separator = File.separator
    val rootPath= {
        val root = File(".").absolutePath
        if (root.length > 1 && root[1] == ':') root.substring(0,2)
        else
            "/"
    }
}
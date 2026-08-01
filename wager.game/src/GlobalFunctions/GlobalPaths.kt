package GlobalFunctions

import java.io.File
import java.nio.file.Paths
import java.util.*


/**
 * Object that contains all the paths necessary to locate files and delete them.
 * @author CallMeMosaic
 * @version 1.0
 * @since 1.0
 *
 * @os The OS the program is running on.
 * @home The home directory of the user.
 * @documents The documents directory of the user.
 * @downloads The downloads directory of the user.
 *
 */

object GlobalPaths {
    private val os = System.getProperty("os.name").lowercase(Locale.getDefault())
    private val home = System.getProperty("user.home")

    val documents: String
        get() = when {
            os.contains("win") -> System.getenv("USERPROFILE")?.let { "$it\\Documents" }
                ?: Paths.get(home, "Documents").toString()

            os.contains("mac") -> Paths.get(home, "Documents").toString()
            else -> {
                // Linux: Respect XDG if available, fallback to English default
                val xdgDocs = System.getenv("XDG_DOCUMENTS_DIR")
                if (!xdgDocs.isNullOrBlank()) xdgDocs
                else Paths.get(home, "Documents").toString()
            }
        }

    val downloads: String
        get() = when {
            os.contains("win") -> System.getenv("USERPROFILE")?.let { "$it\\Downloads" }
                ?: Paths.get(home, "Downloads").toString()

            os.contains("mac") -> Paths.get(home, "Downloads").toString()
            else -> {
                val xdgDown = System.getenv("XDG_DOWNLOAD_DIR")
                if (!xdgDown.isNullOrBlank()) xdgDown
                else Paths.get(home, "Downloads").toString()
            }
        }

    val desktop: String
        get() = when {
            os.contains("win") -> {
                // Windows: Check Env Var first, then default
                System.getenv("USERPROFILE")?.let { "$it\\Desktop" }
                    ?: Paths.get(home, "Desktop").toString()
            }

            os.contains("mac") -> Paths.get(home, "Desktop").toString()
            else -> {
                // Linux: XDG spec is mandatory for reliability
                val xdgDesktop = System.getenv("XDG_DESKTOP_DIR")
                if (!xdgDesktop.isNullOrBlank()) xdgDesktop
                else Paths.get(home, "Desktop").toString()
            }
        }

    val pictures: String
        get() = when {
            os.contains("win") -> {
                System.getenv("USERPROFILE")?.let { "$it\\Pictures" }
                    ?: Paths.get(home, "Pictures").toString()
            }

            os.contains("mac") -> Paths.get(home, "Pictures").toString()
            else -> {
                // Linux: Check XDG_PICTURES_DIR
                val xdgPictures = System.getenv("XDG_PICTURES_DIR")
                if (!xdgPictures.isNullOrBlank()) xdgPictures
                else Paths.get(home, "Pictures").toString()
            }
        }

    val videos: String
        get() = when {
            os.contains("win") -> {
                System.getenv("USERPROFILE")?.let { "$it\\Videos" }
                    ?: Paths.get(home, "Videos").toString()
            }

            os.contains("mac") -> {
                // CRITICAL: macOS uses "Movies", not "Videos"
                Paths.get(home, "Movies").toString()
            }

            else -> {
                // Linux: Check XDG_VIDEOS_DIR
                val xdgVideos = System.getenv("XDG_VIDEOS_DIR")
                if (!xdgVideos.isNullOrBlank()) xdgVideos
                else Paths.get(home, "Videos").toString()
            }
        }
    val wagers: String
        get() = File(desktop, "Wagers").absolutePath
}
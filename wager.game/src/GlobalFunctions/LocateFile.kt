package GlobalFunctions

import java.io.File


/**
 * Interface providing all locate file methods, descending by methods.
 *
 * @author CallMeMosaic
 * @version 1.0
 * @since 1.0
 */
interface LocateFile {

    /**
     * @author CallMeMosaic
     * Locates a file by name and size in a given directory.
     * @param fileName The name of the file to locate.
     * @param fileSize The size of the file to locate.
     * @param directory The directory to search in.
     * @param extension The extension of the file to locate.
     * @return The path of the located file, or null if not found.
     *
     * O-Notation: O(2^n)
     */
    fun locateFileByNameAndSize(fileName: String, fileSize: Long, directory: String, extension: String?): String?{
        val currentDirectory = File(directory)
        if (!currentDirectory.exists()){ return null}
        return currentDirectory.walk()
                // Filters out the wager folder

                // TOFIX!!!!
                
                .onEnter {
                    if (it.isDirectory && it.absolutePath == GlobalPaths.wagers) return@onEnter false
                    true
                }

                // Walks through the directory and it's subdirectories to find the designated file by it's name and size
                .find { it.name == fileName && it.length() == fileSize }
                ?.absolutePath // Returns the full path as a String, or null if not found
        }


}
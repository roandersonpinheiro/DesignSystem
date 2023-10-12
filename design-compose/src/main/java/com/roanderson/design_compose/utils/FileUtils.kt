import java.io.File

object FileUtils {
   
    fun readTextFromFile(filePath: String): String {
        return File(filePath).readText()
    }

  
    fun writeTextToFile(filePath: String, text: String) {
        File(filePath).writeText(text)
    }

    
    fun fileExists(filePath: String): Boolean {
        return File(filePath).exists()
    }

  
    fun listFilesInDirectory(directoryPath: String): Array<File> {
        val directory = File(directoryPath)
        return directory.listFiles() ?: emptyArray()
    }


    fun deleteFile(filePath: String) {
        val file = File(filePath)
        if (file.exists()) {
            file.delete()
        }
    }
}

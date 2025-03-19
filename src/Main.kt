import java.nio.file.Path
import java.util.Scanner
import kotlin.io.path.listDirectoryEntries

fun main() {
    var directoryString: String

    val scnr = Scanner(System.`in`)
    print("Please enter a file directory: ")
    directoryString = scnr.nextLine()

    val directory = Path.of(directoryString)
    val files = directory.listDirectoryEntries()

    var downloadInfo = ArrayList<Double>()
    var uploadInfo = ArrayList<Double>()

    for (i in 0 .. (files.size - 1)) {
        val fileName: String = files.get(i).toString()
        if (fileName.contains(".txt")) {
            val file = Path.of(fileName)
            val inScnr = Scanner(file)

            while (inScnr.hasNextLine()) {
                val line = inScnr.nextLine()
                if (line.contains("Download")) {
                    var value: Double = 0.0
                    val lineScnr = Scanner(line)
                    while (lineScnr.hasNext()) {
                        if (lineScnr.hasNextDouble()) {
                            value = lineScnr.nextDouble()
                            downloadInfo.add(value)
                            break
                        }
                        else {
                            lineScnr.next()
                        }
                    }
                }

                else if (line.contains("Upload")) {
                    var value: Double = 0.0
                    val lineScnr = Scanner(line)
                    while (lineScnr.hasNext()) {
                        if (lineScnr.hasNextDouble()) {
                            value = lineScnr.nextDouble()
                            uploadInfo.add(value)
                            break
                        }
                        else {
                            lineScnr.next()
                        }

                    }
                }

            }
        }

    }

    var downloadAverage: Double = 0.0
    var uploadAverage: Double = 0.0

    for (i in 0 .. (downloadInfo.size - 1)) {
        downloadAverage = downloadAverage + downloadInfo.get(i)
    }
    downloadAverage = downloadAverage / (downloadInfo.size * 1.0)

    for (i in 0 .. (uploadInfo.size - 1)) {
        uploadAverage = uploadAverage + uploadInfo.get(i)
    }
    uploadAverage = uploadAverage / (uploadInfo.size * 1.0)

    println("Average Download Speed: ${String.format("%.2f", downloadAverage)} mbps")
    println("Average Upload Speed: ${String.format("%.2f", uploadAverage)} mbps")

}
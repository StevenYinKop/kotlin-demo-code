import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.lang.Thread.sleep
import java.net.HttpURLConnection.HTTP_OK
import java.net.MalformedURLException
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


@Serializable
data class BookItem(
        val id: String,
        val name: String,
        val banner: String,
        val introduction: String,
        val authorName: String,
        val audioUrl: String,
        val audioDuration: String,
        val shortIntro: String
)

fun downloadFile(url: String, destinationFile: File) {
    // Create SSLContext that trusts all certificates
    val context = SSLContext.getInstance("TLS")
    context.init(null, arrayOf<TrustManager>(object : X509TrustManager {
        override fun checkClientTrusted(chain: Array<out java.security.cert.X509Certificate>, authType: String) {}
        override fun checkServerTrusted(chain: Array<out java.security.cert.X509Certificate>, authType: String) {}
        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
    }), null)

    val url = try {
        URL(url)
    } catch (e: MalformedURLException) {
        System.err.println("download error! Met ${e.message} while downloading $url")
        return
    }
    val connection =
        url.openConnection() as HttpsURLConnection
    connection.sslSocketFactory = context.socketFactory
    val responseCode = connection.responseCode
    if (responseCode == HTTP_OK) {
        val inputStream = BufferedInputStream(connection.inputStream)
        val outputStream = FileOutputStream(destinationFile)

        inputStream.use { input ->
            outputStream.use { output ->
                val data = ByteArray(1024)
                var count: Int
                while (input.read(data).also { count = it } != -1) {
                    output.write(data, 0, count)
                }
            }
        }
    } else {
        System.err.println("download error! Met ${responseCode} while downloading $url")
    }
}

fun download(prefix: String, fileName: String, url: String) {
    println("$prefix Start downloading audio: $fileName...")
    if (!File(fileName).exists()) {
        downloadFile(url, File(fileName))
    }
    println("$prefix Audio $fileName downloaded!")
}

private val json = Json { ignoreUnknownKeys = true }


@ExperimentalSerializationApi
fun main() {
    val inputStream: InputStream? = object {}.javaClass.getResourceAsStream("./audios.json")
    var data: List<BookItem> = emptyList()
    if (inputStream != null) {
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        data = json.decodeFromString(jsonString)
    }
    val downloadPath = "downloads/"

    data.forEachIndexed { index, item ->
        val prefix = "[${index + 1}/${data.size}]: "
        val mindMapName = "https://mini-cdn.bzy.ai/wanke/images/dushu/brain/${item.id}.jpg"
        val folderPath = downloadPath + "${String.format("%03d", index + 1)}${item.name}"
        File(folderPath).mkdirs()

        // Download the audio file
        download(prefix, "${folderPath}/${item.name}.mp3", item.audioUrl)
        // Download the banner image
        download(prefix, "${folderPath}/banner.jpg", item.banner)
        // Download the mindmap image
        download(prefix, "${folderPath}/mindmap.jpg", mindMapName)
        // Save introduction, name, and authorName in a text file
        val infoFileName = "${folderPath}/info.json"
        File(infoFileName).writeText(
            json.encodeToString(BookItem.serializer(), item)
        )
        sleep(1000)
    }
}

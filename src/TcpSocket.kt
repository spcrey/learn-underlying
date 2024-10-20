import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.ServerSocket
import java.net.Socket

object TcpSocket {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        val serverJob = CoroutineScope(Dispatchers.IO).launch {
            try {
                serverRun()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        val clientJobs: MutableList<Job> = mutableListOf()
        repeat(3) { i ->
            clientJobs.add(CoroutineScope(Dispatchers.IO).launch {
                clientRun("message$i")
            })
            delay(200)
        }
        clientJobs.forEach { it.join() }
        serverJob.cancel()
    }
    private suspend fun handleClient(socket: Socket) {
        withContext(Dispatchers.IO) {
            delay(2000)
            val inputStream = socket.inputStream
            val inputStreamReader = inputStream.bufferedReader()
            val bufferedReader = BufferedReader(inputStreamReader)
            val message = bufferedReader.readLine()
            println("server: $message from client")
            val bufferedWriter = BufferedWriter(OutputStreamWriter(socket.outputStream))
            bufferedWriter.write(message)
            bufferedWriter.flush()
            socket.close()
        }
    }
    private suspend fun serverRun() {
        withContext(Dispatchers.IO) {
            val serverSocket = ServerSocket(8888)
            while (true) {
                val socket = serverSocket.accept()
                CoroutineScope(Dispatchers.IO).launch {
                    handleClient(socket)
                }
            }
        }
    }
    private fun clientRun(sendMessage: String) {
        try {
            val socket = Socket("localhost", 8888)
            val inputStream = socket.inputStream
            val outputStream = socket.outputStream
            val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream))
            println("client: start to send $sendMessage\n")
            bufferedWriter.write("$sendMessage\n")
            bufferedWriter.flush()
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val receiveMessage = bufferedReader.readLine()
            println("client: $receiveMessage from server\n")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

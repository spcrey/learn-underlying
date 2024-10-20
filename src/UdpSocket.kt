import kotlinx.coroutines.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

object UdpSocket {
    private val IoScope = CoroutineScope(Dispatchers.IO)
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        val receiverJob = IoScope.launch {
            receiverRun()
        }
        val senderJobs: MutableList<Job> = mutableListOf()
        repeat(3) {
            senderJobs.add(IoScope.launch {
                senderRun()
            })
            delay(200)
        }
        senderJobs.forEach { it.join() }
        receiverJob.cancel()
    }
    private suspend fun handleSender(datagramPacket: DatagramPacket) {
        withContext(Dispatchers.IO) {
            val data = datagramPacket.data
            val message = String(data, 0, datagramPacket.length)
            println("receiver: $message")
        }
    }
    private suspend fun receiverRun() {
        withContext(Dispatchers.IO) {
            val datagramSocket = DatagramSocket(8888)
            val bytes = ByteArray(1024)
            val datagramPacket = DatagramPacket(bytes, bytes.size)
            while (true) {
                datagramSocket.receive(datagramPacket)
                IoScope.launch {
                    handleSender(datagramPacket)
                }
            }
        }
    }
    private suspend fun senderRun() {
        withContext(Dispatchers.IO) {
            val datagramSocket = DatagramSocket()
            val message = "message from sender"
            println("sender: $message")
            val bytes = message.toByteArray()
            val inetAddress = InetAddress.getByName("localhost")
            val datagramPacket = DatagramPacket(bytes, bytes.size, inetAddress, 8888)
            datagramSocket.send(datagramPacket)
            datagramSocket.close()
        }
    }
}
import collections.*

object MainKotlin {
    @JvmStatic
    fun main(args:Array<String>) {
        val linkedList = LinkedList<Int>()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        println(linkedList)
        println(linkedList[2])
        linkedList[2] = 5
        println(linkedList)
        val iterator = linkedList.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }
}
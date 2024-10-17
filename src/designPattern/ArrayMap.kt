package designPattern

object ArrayMap {
    interface LearnArrayMap {
        fun learn() : Unit
    }

    class LearnArray : LearnArrayMap {
        override fun learn() {
            val intArray = intArrayOf(1, 2, 3)
            intArray[0] = 4
            println(intArray.contentToString())

            val floatArray = floatArrayOf(1.0f, 2.0f, 3.0f)
            println(floatArray.toList())
        }
    }

    class LearnMutableList : LearnArrayMap {
        override fun learn() {
            val list = listOf(1, 2, 3)
            println(list)

            val mutableList = mutableListOf(1, 2, 3, 4, 5, 6)
            println(mutableList.subList(1,3).toMutableList() + mutableListOf(8,8,8,8,8))
        }
    }

    class LearnSet : LearnArrayMap {
        override fun learn() {
            val mutableSetOf  = mutableSetOf(1, 2, 3)
            println(mutableSetOf.add(4))
            println(mutableSetOf.add(1))
            println(mutableSetOf)
        }
    }

    class LearnMap : LearnArrayMap {
        override fun learn() {
            val mutableMap = mutableMapOf(1 to "one", 2 to "two", 3 to "three")
            mutableMap[1] = "one"
            mutableMap[1] = "1"
            println(mutableMap.put(4, "four"))
            println(mutableMap.put(4, "four:4"))
            println(mutableMap)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var learnArrayMap: LearnArrayMap? = null
        learnArrayMap = LearnMap()
        learnArrayMap.learn()
    }
}
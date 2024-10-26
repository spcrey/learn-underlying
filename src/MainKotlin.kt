object MainKotlin {
    @JvmStatic
    fun main(args:Array<String>) {

    }

    open class Companion {

    }

    open class Detector : Companion() {

    }

    class Executor : Detector() {

    }

    class Suppressor : Detector() {

    }

    class Modulator : Detector() {

    }
}


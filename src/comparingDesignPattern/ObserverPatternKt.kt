package comparingDesignPattern

object ObserverPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val observer = Observer()
        Observable("observable1", observer)
        Observable("observable2", observer)
        Observable("observable3", observer)
        observer.notifyObservables()
    }
    class Observer {
        private val observables = mutableListOf<Observable>()
        fun addObservable(observable: Observable) {
            observables.add(observable)
        }
        fun notifyObservables() {
            observables.forEach { it.showMessage() }
        }
    }
    class Observable(val name: String, observer: Observer) {
        init {
            observer.addObservable(this)
        }
        fun showMessage() {
            println("Observer($name).showMessage()")
        }
    }
}
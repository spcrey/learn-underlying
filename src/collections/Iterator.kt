package collections

interface Iterator<T> {
    /**
     * Returns the next element in the iteration.
     * **/
    fun next(): T
    /**
     * Returns `true` if the iteration has more elements.
     */
    fun hasNext(): Boolean
}
package collections

/**
 * Classes that inherit from this interface can be represented as a sequence of elements that can be iterated over.
 * @param T the type of element being iterated over.
 * The iterator is covariant in its element type.
 * */
interface Iterable<T> {
    fun iterator(): Iterator<T>
}

/**
 * 集合
 * **/
interface Collection<T> : Iterable<T> {
    /**
     * Return number of containing elements contained the collection
     * **/
    val size: Int

    /**
     * To check if an element is contained within the collection and return `true`
     * **/
    fun contains(element: T): Boolean

    /**
     * Return `true` if the collection contains no element
     * **/
    fun isEmpty(): Boolean
}

interface List<T> : Collection<T> {
    /**
     * Returns the element at the specified index in the list
     * **/
    operator fun get(index: Int): T

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * **/
    operator fun set(index: Int, element: T)

    /**
     * Add the element at the last position in this list.
     * **/
    fun add(element: T)

    override fun toString(): String
}

interface MutableCollection<E>

interface Stack<E> {
    fun push(element: E)

    fun pop(): E

    fun peek(): E
}

interface Queue<E> {
    fun add(element: E)

    fun pop(): E

    fun peek(): E
}

class Set<E> : Iterable<E> {
    override fun iterator(): Iterator<E> {
        TODO("Not yet implemented")
    }
}

class HashMap<K, V>

class ArrayList<E> : List<E> {
    override val size: Int
        get() = elements.size

    /**
     * Data of elements
     * **/
    private val elements = mutableListOf<E>()

    override fun get(index: Int): E {
        if (index in 0 until size)
            return elements[index]
        else
            throw IndexOutOfBoundsException()
    }

    override fun toString(): String {
        return elements.toString()
    }

    override fun add(element: E) {
        elements.add(element)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun contains(element: E): Boolean {
        return elements.contains(element)
    }

    override fun set(index: Int, element: E) {
        elements[index] = element
    }

    override fun iterator(): Iterator<E> {
        return ArrayListIterator(this)
    }
}

interface Map<K, V> {
    fun put(key: K, value: V)
    operator fun get(key: K): V?
    override fun toString(): String
}

class LruCache<K, V>(private val capacity: Int) : Map<K, V> {
    private val linkedHashMap = LinkedHashMap<K, V>(capacity)

    private var size = 0

    override fun put(key: K, value: V) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key)
            size -= 1
        } else {
            if (size == capacity) {
                linkedHashMap.remove(linkedHashMap.keys.first())
                size -= 1
            }
        }
        linkedHashMap[key] = value
        size += 1
    }

    override operator fun get(key: K): V? {
        val value = linkedHashMap.remove(key)
        value?.let {
            linkedHashMap[key] = value
            return value
        } ?: return null
    }

    override fun toString(): String {
        return linkedHashMap.toString()
    }
}

private class ArrayListIterator<E>(private val elements: ArrayList<E>) : Iterator<E> {
    private var index = 0
    override fun next(): E {
        if (index >=0 && index < elements.size) {
            return elements[index++]
        } else {
            throw NoSuchElementException()
        }
    }

    override fun hasNext(): Boolean {
        return index < elements.size
    }
}

private class LinkedListNode<E>(
    var value: E? = null,
    var next: LinkedListNode<E>? = null,
)

class LinkedList<E> : List<E> {
    override val size: Int
        get() {
            var count  = 0
            var node = head.next
            while (node != null) {
                node = node.next
                count ++
            }
            return count
        }

    /**
     * Head node of element nodes
     * **/
    private val head = LinkedListNode<E>()

    private fun getNode(index: Int): LinkedListNode<E>? {
        var node = head.next
        for (i in 0 until index) {
            if (node == null) {
                return null
            }
            node = node.next
        }
        return node
    }

    override fun get(index: Int): E {
        getNode(index)?.let {
            return it.value!!
        } ?: throw IndexOutOfBoundsException()
    }

    override fun toString(): String {
        var content = "["
        var node = head.next
        var count = 0
        while (node != null) {
            if (count > 0) {
                content += " "
            }
            content += node.value
            node = node.next
            count ++
        }
        content += "]"
        return content
    }

    override fun add(element: E) {
        var node = head
        while (node.next != null) {
            node = node.next!!
        }
        node.next = LinkedListNode(element)
    }

    override fun isEmpty(): Boolean {
        return head.next == null
    }

    override fun contains(element: E): Boolean {
        var node = head.next
        while (node != null) {
            if (node == element) {
                return true
            }
            node = node.next
        }
        return false
    }

    override fun set(index: Int, element: E) {
        getNode(index)?.let {
            it.value = element
        } ?: throw IndexOutOfBoundsException()
    }

    override fun iterator(): Iterator<E> {
        return LinkedListIterator(head)
    }
}

private class LinkedListIterator<E>(private var preNode: LinkedListNode<E>) : Iterator<E> {
    override fun next(): E {
        preNode.next?.let {
            val value = it.value!!
            preNode = it
            return value
        } ?: throw IndexOutOfBoundsException()
    }

    override fun hasNext(): Boolean {
        return preNode.next != null
    }
}

interface BinaryTreeTraversalTransformer<E> {
    fun transform(binaryTree: WithLeftRight<E>)
}

class PreOrderBinaryTreeTraversalTransformer<E> : BinaryTreeTraversalTransformer<E> {
    override fun transform(binaryTree: WithLeftRight<E>) {
        TODO("Not yet implemented")
    }
}

interface TreeNode<E> {
    var value: E

    fun isLeafNode(): Boolean
}

interface Group<E> {
    val children: ArrayList<E>

    fun add(child: E) {
        children.add(child)
    }

    operator fun get(index: Int): E {
        return children[index]
    }
}

class LeafTreeNode<E>(override var value: E) : TreeNode<E> {
    override fun isLeafNode(): Boolean {
        return true
    }
}

class NonLeafTreeNode<E>(
    override var value: E,
) : TreeNode<E>, Group<TreeNode<E>> {

    override val children: ArrayList<TreeNode<E>> = ArrayList()

    override fun isLeafNode(): Boolean {
        return false
    }
}

interface Node<E> {
    var value: E?
}

interface WithLeftRight<E> {
    var left: WithLeftRight<E>?
    var right: WithLeftRight<E>?
}

class BinaryTree<E> (
    override var value: E?,
    override var left: WithLeftRight<E>?,
    override var right: WithLeftRight<E>?,
) : WithLeftRight<E>, Node<E>

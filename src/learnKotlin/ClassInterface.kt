package learnKotlin

object ClassInterface {

    class Person(name: String, private val age: Int) {
        val name = "name:$name"
        init {
            println(name)

        }
        init {
            println(age)
        }
        constructor(name: String) : this(name, 13) {
            println("constructor")
        }
    }

    class Singleton private constructor(private var name: String) {
        companion object {
            @Volatile private var instance: Singleton? = null
            fun getInstance(name: String): Singleton {
                if (instance == null) {
                    synchronized(Singleton::class.java) {
                        if (instance == null) {
                            instance = Singleton(name)
                        }
                    }
                }
                return instance!!
            }
        }
        fun print() {
            println("name=$name")
        }
    }

    interface EatAction{
        fun eat()
    }

    interface RunAction{
        fun run()
    }

    abstract class Animal(val name: String){
        abstract fun print()
    }

    open class Child(open val name: String, open val age: Int) {
        open fun print() {
            print("child: name=$name, age=$age")
        }
    }

    class Student(override val name: String, override val age: Int) : Child(name, age) {
        override fun print() {
            print("student: name=$name, age=$age")
        }
    }

    class Dog(name: String) : Animal(name), EatAction, RunAction{
        override fun print() {
            println("Dog name is $name")
        }

        override fun eat() {
            println("$name eat")
        }

        override fun run() {
            println("$name run")
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val person1 = Person("Ling Xue", 18)
        val person2 = Person("Ling Yu")
        Singleton.getInstance("Ling Yao").print()
        Singleton.getInstance("Ling Ling").print()
        val dog = Dog("Dog")
        dog.eat()
        dog.run()
        dog.print()
    }

}
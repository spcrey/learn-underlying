package comparingDesignPattern

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object ProxyPatternKt {
    @JvmStatic
    fun main(args: Array<String>) {
        val realSubject: Subject = RealSubject()
        val staticProxySubject = StaticProxySubject(realSubject)
        staticProxySubject.method()
        val dynamicProxySubject = Proxy.newProxyInstance(
            realSubject.javaClass.classLoader,
            arrayOf(Subject::class.java),
            DynamicProxySubject(realSubject)
        ) as Subject
        dynamicProxySubject.method()
    }
    interface Subject {
        fun method()
    }
    class RealSubject : Subject {
        override fun method() {
            println("RealSubject.method()")
        }
    }
    class StaticProxySubject(private val realSubject: Subject) : Subject {
        override fun method() {
            println("StaticProxySubject: pre action")
            realSubject.method()
            println("StaticProxySubject: after action")
        }
    }
    class DynamicProxySubject(private val realSubject: Subject) : InvocationHandler  {
        override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any? {
            println("DynamicProxySubject: pre action")
            val result = if (method.parameterCount == 0) {
                method.invoke(realSubject)
            } else {
                method.invoke(realSubject, args)
            }
            println("DynamicProxySubject: after action")
            return result
        }
    }
}
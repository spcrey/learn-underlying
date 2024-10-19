package comparingDesignPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPatternJava {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject staticProxySubject = new StaticProxySubject(realSubject);
        staticProxySubject.method();
        Subject dynamicProxySubject = (Subject) Proxy.newProxyInstance(
            realSubject.getClass().getClassLoader(),
            new Class[]{Subject.class},
            new DynamicProxySubject(realSubject)
        );
        dynamicProxySubject.method();
    }
    interface Subject {
        void method();
    }
    static class RealSubject implements Subject {
        @Override
        public void method() {
            System.out.println("RealSubject.method()");
        }
    }
    static class StaticProxySubject implements Subject {
        private final Subject realSubject;

        public StaticProxySubject(Subject realSubject) {
            this.realSubject = realSubject;
        }
        @Override
        public void method() {
            System.out.println("StaticProxySubject: pre action");
            realSubject.method();
            System.out.println("StaticProxySubject: after action");
        }
    }

    static class DynamicProxySubject implements InvocationHandler {
        final private Object realSubject;

        public DynamicProxySubject(Object realSubject) {
            this.realSubject = realSubject;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("DynamicProxySubject: pre action");
            Object result = method.invoke(realSubject, args);
            System.out.println("DynamicProxySubject: after action");
            return result;
        }
    }
}

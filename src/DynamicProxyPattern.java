import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyPattern {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                new Class[]{Subject.class},
                new MyInvocationHandler(realSubject)
        );
        proxySubject.run();
    }

    interface Subject {
        void run();
    }

    static class RealSubject implements Subject {
        @Override
        public void run() {
            System.out.println("real subject run");
        }
    }

    static class MyInvocationHandler implements InvocationHandler {

        private final Object realSubject;

        public MyInvocationHandler(Object realSubject) {
            this.realSubject = realSubject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Before method: " + method.getName());
            Object result = method.invoke(realSubject, args);
            System.out.println("After method: " + method.getName());
            return result;
        }
    }
}

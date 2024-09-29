package nativeCpp;

public class NativeCpp {
    public native void hello();

    public static void main(String[] args) {
        NativeCpp instance = new NativeCpp();
        instance.hello();
    }
}

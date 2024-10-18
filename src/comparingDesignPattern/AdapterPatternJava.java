package comparingDesignPattern;

public class AdapterPatternJava {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        System.out.println(adapter.transform());
    }
    interface Transformer {
        String transform();
    }
    static class Adaptee {
        public String method() {
            return "Adaptee.method()";
        }
    }
    static class Adapter implements Transformer {
        private final Adaptee adaptee;

        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }
        private String transformContent(String content) {
            System.out.println("Adapter.transformContent()");
            return "Transformed " + content;
        }
        @Override
        public String transform() {
            String content = adaptee.method();
            content = transformContent(content);
            return content;
        }
    }
}

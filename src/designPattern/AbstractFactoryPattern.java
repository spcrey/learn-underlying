package designPattern;

public class AbstractFactoryPattern {
    public static void main(String[] args){
        Factory factory = new BeijingFactory();
        Phone huawei = factory.createPhone("huawei");
        huawei.method();
        Phone iphone = factory.createPhone("iphone");
        iphone.method();
        Mask n95 = factory.createMask("n95");
        n95.method();
        Mask disposableMask = factory.createMask("disposable mask");
        disposableMask.method() ;

        factory = new GuangdongFactory();
        Phone xiaomi = factory.createPhone("xiaomi");
        xiaomi.method();
        Phone oppo = factory.createPhone("oppo");
        oppo.method();
        Mask kn95 = factory.createMask("kn95");
        kn95.method();
        Mask fashionMask = factory.createMask("fashion mask");
        fashionMask.method();
    }

    interface Phone {
        void method();
    }

    static class Iphone implements Phone {
        @Override
        public void method() {
            System.out.println("Phone.Iphone.method");
        }
    }

    static class Huawei implements Phone {
        @Override
        public void method() {
            System.out.println("Phone.Huawei.method");
        }
    }

    static class Xiaomi implements Phone {
        @Override
        public void method() {
            System.out.println("Phone.Xiaomi.method");
        }
    }

    static class Oppo implements Phone {
        @Override
        public void method() {
            System.out.println("Phone.Oppo.method");
        }
    }

    interface Mask {
        void method();
    }

    static class N95 implements Mask {
        @Override
        public void method() {
            System.out.println("Mask.N95.method");
        }
    }

    static class DisposibleMask implements Mask {
        @Override
        public void method() {
            System.out.println("Mask.DisposableMask.method");
        }
    }

    static class Kn95 implements Mask {
        @Override
        public void method() {
            System.out.println("Mask.Kn95.method");
        }
    }

    static class FashionMask implements Mask {
        @Override
        public void method() {
            System.out.println("Mask.FashionMask.method");
        }
    }

    interface Factory {
        Phone createPhone(String phone_name);
        Mask createMask(String mask_name);
    }

    static class BeijingFactory implements Factory {
        @Override
        public Phone createPhone(String phone_name){
            return switch (phone_name) {
                case "huawei" -> new Huawei();
                case "iphone" -> new Iphone();
                default -> throw new IllegalArgumentException("no phone named " + phone_name + "in the factory");
            };
        }

        @Override
        public Mask createMask(String mask_name){
            return switch (mask_name) {
                case "n95" -> new N95();
                case "disposable mask" -> new DisposibleMask();
                default -> throw new IllegalArgumentException("no mask named " + mask_name + "in the factory");
            };
        }
    }

    static class GuangdongFactory implements Factory {
        @Override
        public Phone createPhone(String phone_name){
            return switch (phone_name) {
                case "xiaomi" -> new Xiaomi();
                case "oppo" -> new Oppo();
                default -> throw new IllegalArgumentException("no phone named " + phone_name + "in the factory");
            };
        }

        @Override
        public Mask createMask(String mask_name){
            return switch (mask_name) {
                case "kn95" -> new Kn95();
                case "fashion mask" -> new FashionMask();
                default -> throw new IllegalArgumentException("no mask named " + mask_name + "in the factory");
            };
        }
    }
}



package comparingDesignPattern;

public class FacadePatternJava {
    public static void main(String[] args) {
        Facade facade = new Facade();
        System.out.println(facade.step());
    }
    static class Facade {
        public boolean step() {
            if (step1() && step2() && step3()) {
                System.out.println("Facade.step()");
                return true;
            } else {
                return false;
            }
        }
        public boolean step1() {
            System.out.println("Facade.Step1()");
            return true;
        }
        public boolean step2() {
            System.out.println("Facade.Step2()");
            return true;
        }
        public boolean step3() {
            System.out.println("Facade.Step3()");
            return true;
        }
    }
}

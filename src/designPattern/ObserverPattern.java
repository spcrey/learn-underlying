package designPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Debit zhang3 = new ZhangSan();
        Credit li4 = new LiSi();
        Credit wang5 = new WangWu();
        zhang3.borrow(li4);
        zhang3.borrow(wang5);
        zhang3.notifyCredits();
    }

    interface Debit {
        void borrow(Credit credit);
        void notifyCredits();
    }

    static class ZhangSan implements Debit {
        private final List<Credit> credits = new ArrayList<>();
        public void borrow(Credit credit) {
            credits.add(credit);
        }
        public void notifyCredits(){
            for(Credit credit: credits){
                credit.takeMoney();
            }
        }
    }

    interface Credit {
        void takeMoney();
    }

    static class LiSi implements Credit {
        public void takeMoney() {
            System.out.println("LiSi takes money");
        }
    }

    static class WangWu implements Credit {
        public void takeMoney() {
            System.out.println("WangWu takes money");
        }
    }
}

package comparingDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternJava {
    public static void main(String[] args) {
        Observer observer = new Observer();
        new Observable("observable1", observer);
        new Observable("observable2", observer);
        new Observable("observable3", observer);
        observer.notifyObserved();
    }
    static class Observer {
        private final List<Observable> observables =  new ArrayList<>();

        public void addObservable(Observable observed) {
            observables.add(observed);
        }
        public void notifyObserved() {
            observables.forEach(Observable::showMessage);
        }
    }
    static class Observable {
        private final String name;
        public Observable(String name, Observer observer) {
            this.name = name;
            observer.addObservable(this);
        }
        public void showMessage() {
            System.out.println(name + " showMessage");
        }
    }
}

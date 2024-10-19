package comparingDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class IteratorPatternJava {
    public static void main(String[] args) {
        Container<Integer> container = new ConcreteContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        Iterator<Integer> iterator = container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    interface Iterator<T> {
        boolean hasNext();
        T next();
    }
    interface Container<T> {
        Iterator<T> iterator();
        void add(T t);

        int size();
        T getItem(int index);
    }
    static class ConcreteIterator<T> implements Iterator<T> {
        private final ConcreteContainer<T> concreteContainer;
        private int index = 0;
        public ConcreteIterator(ConcreteContainer<T> concreteContainer) {
            this.concreteContainer = concreteContainer;
        }
        @Override
        public boolean hasNext() {
            return index < concreteContainer.size();
        }
        @Override
        public T next() {
            return concreteContainer.getItem(index++);
        }
    }
    static class ConcreteContainer<T> implements Container<T> {
        private final List<T> list = new ArrayList<>();
        @Override
        public Iterator<T> iterator() {
            return new ConcreteIterator<>(this);
        }
        @Override
        public void add(T t) {
            list.add(t);
        }
        @Override
        public int size() {
            return list.size();
        }
        @Override
        public T getItem(int index) {
            return list.get(index);
        }
    }
}

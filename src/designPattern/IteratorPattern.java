package designPattern;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args) {
        Container<String> collection = new ConcreteContainer<>();
        collection.add("123");
        collection.add("456");
        collection.add("567");
        collection.add("678");
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    interface Iterator<T> {
        boolean hasNext();
        T next();
    }

    interface Container<T> {
        Iterator<T> iterator();
        void add(T item);
    }

    static class ConcreteIterator<T> implements Iterator<T>{
        private final List<T> list;
        private int index;

        public ConcreteIterator(List<T> list) {
            this.list = list;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }

    static class ConcreteContainer<T> implements Container<T> {
        private final List<T> list;

        public ConcreteContainer() {
            this.list = new ArrayList<>();
        }

        @Override
        public void add(T item) {
            list.add(item);
        }

        @Override
        public Iterator<T> iterator() {
            return new ConcreteIterator<>(list);
        }
    }
}
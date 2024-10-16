import java.util.*;

public class CollectionMap {
    interface LearnCollectionMap {
        void learn();
    }

    static class LearnArrayList implements LearnCollectionMap {
        @Override
        public void learn() {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("A");
            arrayList.add("B");
            arrayList.add("C");
            System.out.println(arrayList);
        }
    }

    static class LearnLinkedList implements LearnCollectionMap {
        @Override
        public void learn() {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            System.out.println(linkedList);
        }
    }

    static class LearnStack implements LearnCollectionMap {
        @Override
        public void learn() {
            Stack<String> stack = new Stack<>();
            stack.push("A");
            stack.push("B");
            stack.push("C");
            System.out.println(stack.pop());
            System.out.println(stack);
        }
    }

    static class LearnArrayDeque implements LearnCollectionMap {
        @Override
        public void learn() {
            ArrayDeque<String> arrayDeque = new ArrayDeque <>();
            arrayDeque.offer("A");
            arrayDeque.offer("C");
            arrayDeque.offer("B");
            System.out.println(arrayDeque.poll());
            System.out.println(arrayDeque);
        }
    }

    static class LearnPriorityQueue implements LearnCollectionMap {
        @Override
        public void learn() {
            PriorityQueue<String> arrayDeque = new PriorityQueue <>();
            arrayDeque.offer("A");
            arrayDeque.offer("C");
            arrayDeque.offer("B");
            System.out.println(arrayDeque.poll());
            System.out.println(arrayDeque);
        }
    }

    static class LearnHashMap implements LearnCollectionMap {
        @Override
        public void learn() {
            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(1, "A");
            hashMap.put(2, "B");
            hashMap.put(3, "C");
            System.out.println(hashMap);
        }
    }

    static class LearnLinkedHashMap implements LearnCollectionMap {
        @Override
        public void learn() {
            LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
            hashMap.put(1, "A");
            hashMap.put(3, "C");
            hashMap.put(2, "B");
            System.out.println(hashMap);
        }
    }

    static class LearnTreeMap implements LearnCollectionMap {
        @Override
        public void learn() {
            TreeMap<Integer, String> hashMap = new TreeMap<>();
            hashMap.put(1, "A");
            hashMap.put(3, "C");
            hashMap.put(2, "B");
            System.out.println(hashMap);
        }
    }

    static class LearnHashSet implements LearnCollectionMap {
        @Override
        public void learn() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("A");
            hashSet.add("B");
            hashSet.add("C");
            System.out.println(hashSet);
        }
    }

    static class LearnLinkedHashSet implements LearnCollectionMap {
        @Override
        public void learn() {
            LinkedHashSet<String> hashSet = new LinkedHashSet<>();
            hashSet.add("A");
            hashSet.add("C");
            hashSet.add("B");
            System.out.println(hashSet);
        }
    }

    static class LearnTreeSet implements LearnCollectionMap {
        @Override
        public void learn() {
            TreeSet<String> hashSet = new TreeSet<>();
            hashSet.add("A");
            hashSet.add("C");
            hashSet.add("B");
            System.out.println(hashSet);
        }
    }

    public static void main(String[] args) {
        LearnCollectionMap learnCollectionMap;
        learnCollectionMap = new LearnPriorityQueue();
        learnCollectionMap.learn();
    }
}

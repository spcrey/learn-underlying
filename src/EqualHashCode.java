import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualHashCode {
    public static void main(String[] args) {
        Person person1 = new Person("Ling Yu", 17);
        Person person2 = new Person("Ling Xue", 16);
        Person person3 = new Person("Ling Yu", 17);

        Set<Person> persons = new HashSet<>();

        System.out.println(persons.add(person1));
        System.out.println(persons.add(person2));
        System.out.println(persons.add(person3));

        for (Person person : persons) {
            System.out.println(person);
        }
    }

    static class Person {
        private final String name;
        private final int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Person person = (Person) object;
            if (age != person.age) return false;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }

        @Override
        public String toString() {
            return "(" + name + ", " + age + ")";
        }
    }
}

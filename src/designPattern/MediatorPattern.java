package designPattern;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new MediatorImpl();
        Person zhang3 = new PersonImpl("ZhangSan", mediator);
        Person li4 = new PersonImpl("LiSi", mediator);
        Person wang5 = new PersonImpl("WangWu", mediator);
        zhang3.sendMessage("Hello, WangWu", wang5);
        li4.sendMessageToAll("Hello, I'm LiSi");
    }

    interface Mediator {
        void add(Person person);
        void sendMessage(String message, Person sender, Person receiver);
        void sendMessageToAll(String message, Person sender);
    }

    static class MediatorImpl implements Mediator {
        private final List<Person> persons = new ArrayList<>();

        public void add(Person person) {
            persons.add(person);
        }

        public void sendMessage(String message, Person sender, Person receiver) {
            message = "\"" + message + "\" from " + sender.getName() + " to " + receiver.getName();
            receiver.receiveMessage(message);
        }

        public void sendMessageToAll(String message, Person sender) {
            for(Person person: persons) {
                if(person != sender) {
                    sendMessage(message, sender, person);
                }
            }
        }
    }

    interface Person {
        void sendMessage(String message, Person receiver);
        void sendMessageToAll(String message);
        void receiveMessage(String message);
        String getName();
    }

    static class PersonImpl implements Person {
        private final Mediator mediator;
        private final String name;

        public PersonImpl(String name, Mediator mediator) {
            mediator.add(this);
            this.mediator = mediator;
            this.name = name;
        }

        public void sendMessage(String message, Person receiver) {
            mediator.sendMessage(message, this, receiver);
        }

        public void sendMessageToAll(String message) {
            mediator.sendMessageToAll(message, this);
        }

        public void receiveMessage(String message) {
            System.out.println(message);
        }

        public String getName() {
            return name;
        }
    }
}

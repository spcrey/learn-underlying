package designPattern;

public class CommandPattern {
    public static void main(String[] args) {
        Service service = new PrintHelloService();
        Command command = new Command(service);
        Button button = new Button();
        button.bindCommand(command);
        button.pressDown();
    }

    // receiver
    interface Service {
        void print();
    }

    static class PrintHelloService implements Service {
        public void print() {
            System.out.println("Hello World!");
        }
    }

    static class Command {
        private final Service service;

        public Command(Service service) {
            this.service = service;
        }

        public void execute() {
            service.print();
        }
    }

    static class Button {
        private Command command;

        public void bindCommand(Command command) {
            this.command = command;
        }

        public void pressDown() {
            command.execute();
        }
    }
}



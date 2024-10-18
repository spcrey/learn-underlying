package comparingDesignPattern;

import designPattern.CommandPattern;

import java.io.Console;

public class CommandPatternJava {
    public static void main(String[] args) {
        Context context = new Context();
        Command command1 = new CommandA();
        Command command2 = new CommandB();
        Command command3 = new CommandC();
        context.execute();
        context.bind(command1);
        context.execute();
        context.unbind();
        context.execute();
        context.bind(command2);
        context.bind(command3);
        context.execute();

    }
    static abstract class Command {
        abstract void execute();
    }
    static class CommandA extends Command {
        @Override
        void execute() {
            System.out.println("CommandA.execute()");
        }
    }
    static class CommandB extends Command {
        @Override
        void execute() {
            System.out.println("CommandB.execute()");
        }
    }
    static class CommandC extends Command {
        @Override
        void execute() {
            System.out.println("CommandC.execute()");
        }
    }
    static class Context {
        private Command command = null;
        public void bind(Command command) {
            this.command = command;
        }
        public void unbind() {
            this.command = null;
        }
        public void execute() {
            if (command != null) {
                command.execute();
            }
        }
    }
}

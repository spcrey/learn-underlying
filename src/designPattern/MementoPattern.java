package designPattern;

import java.time.LocalTime;
import java.util.Stack;

public class MementoPattern {
    public static void main(String[] args) {
        Document document = new Document();
        History history = new History();
        document.change("abc");
        history.add(document.saveToSnapshot());
        document.change("def");
        history.add(document.saveToSnapshot());
        document.change("hij");
        document.print();
        document.resume(history.getLastVersion());
        document.print();
        document.resume(history.getLastVersion());
        document.print();
    }

    static class Document {
        private String content;

        public void change(String content) {
            this.content = content;
        }

        public Backup saveToSnapshot(){
            return new Backup(content);
        }

        public void resume(Backup backup) {
            this.content = backup.getContent();
        }

        public void print() {
            System.out.println(content);
        }
    }

    static class Backup {
        private final LocalTime dataTime;
        private final String content;

        public LocalTime getDataTime() {
            return dataTime;
        }

        public String getContent() {
            return content;
        }

        public Backup(String content) {
            this.content = content;
            dataTime = LocalTime.now();
        }
    }

    static class History {
        private final Stack<Backup> backupHistory = new Stack<>();

        public void add(Backup backup) {
            backupHistory.add(backup);
        }

        public Backup getLastVersion() {
            return backupHistory.pop();
        }
    }
}

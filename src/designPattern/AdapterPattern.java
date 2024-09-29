package designPattern;

public class AdapterPattern {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        System.out.println(speaker.speak());
        Translator translator = new SpeakerTranslator(speaker);
        System.out.println(translator.translate());
    }

    static class Speaker {
        public String speak() {
            return "speaking content";
        }
    }

    interface Translator {
        String translate();
    }

    static class SpeakerTranslator implements Translator {
        private final Speaker speaker;
        public SpeakerTranslator(Speaker speaker) {
            this.speaker = speaker;
        }
        public String translate(){
            return "** " + speaker.speak() + " ##";
        }
    }
}
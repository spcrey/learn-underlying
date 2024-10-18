package comparingDesignPattern;

import java.util.Objects;

public class BuilderPatternJava {
    public static void main(String[] args) {
        Group group = new Group.Builder()
                .setChildA(new ChildA(6, false))
                .setChildC(new ChildC(5.2f, 2.4))
                .setChildA(new ChildA(4, true))
                .build();
        System.out.println(group);
    }
    static class ChildA {
        private final int param1;
        private final boolean param2;
        public ChildA(int param1, boolean param2) {
            this.param1 = param1;
            this.param2 = param2;
        }
        public ChildA() {
            this.param1 = 0;
            this.param2 = false;
        }
        @Override
        public String toString() {
            return "ChildA(" + param1 + "," + param2 + ")";
        }
    }
    static class ChildB {
        private final char param1;
        public ChildB(char param1) {
            this.param1 = param1;
        }
        public ChildB() {
            this.param1 = '0';
        }
        @Override
        public String toString() {
            return "ChildB(" + param1 + ")";
        }
    }
    static class ChildC {
        private final float param1;
        private final double param2;
        public ChildC(float param1, double param2) {
            this.param1 = param1;
            this.param2 = param2;
        }
        public ChildC() {
            this.param1 = 0f;
            this.param2 = 0.0;
        }
        @Override
        public String toString() {
            return "ChildC(" + param1 + "," + param2 + ")";
        }
    }
    static class Group {
        private final ChildA childA;
        private final ChildB childB;
        private final ChildC childC;
        public Group(ChildA childA, ChildB childB, ChildC childC) {
            this.childA = childA;
            this.childB = childB;
            this.childC = childC;
        }
        public Group(Builder builder) {
            this.childA = Objects.requireNonNullElseGet(builder.childA, ChildA::new);
            this.childB = Objects.requireNonNullElseGet(builder.childB, ChildB::new);
            this.childC = Objects.requireNonNullElseGet(builder.childC, ChildC::new);
        }

        @Override
        public String toString() {
            return "Group(" + childA + "," + childB + "," + childC + ")";
        }
        static final class Builder {
            private ChildA childA = null;
            private ChildB childB = null;
            private ChildC childC = null;
            Builder setChildA(ChildA childA) {
                this.childA = childA;
                return this;
            }
            Builder setChildB(ChildB childB) {
                this.childB = childB;
                return this;
            }
            Builder setChildC(ChildC childC) {
                this.childC = childC;
                return this;
            }
            public Group build() {
                return new Group(this);
            }
        }
    }
}

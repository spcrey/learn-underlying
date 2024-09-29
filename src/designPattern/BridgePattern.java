package designPattern;

public class BridgePattern {
    public static void main(String[] args) {
        DrawFun drawFun = new DrawHeat();
        ImageGenerator imageGenerator = new PurgeImageGenerator(drawFun);
        imageGenerator.draw();
    }

// DrawFun(2) * PurgeImageGenerator(2)

    abstract static class ImageGenerator {
        protected DrawFun drawFun;

        public ImageGenerator(DrawFun drawFun) {
            setDrawFun(drawFun);
        }

        public void setDrawFun(DrawFun drawFun) {
            this.drawFun = drawFun;
        }

        abstract public void draw();
    }

    interface DrawFun {
        String method();
    }

    static class DrawHeat implements DrawFun {
        @Override
        public String method() {
            return "DrawHeat";
        }
    }

    static class DrawContourf implements DrawFun {
        @Override
        public String method() {
            return "DrawContourf";
        }
    }

    static class PurgeImageGenerator extends ImageGenerator {
        public PurgeImageGenerator(DrawFun drawFun) {
            super(drawFun);
        }

        @Override
        public void draw() {
            System.out.println("PurgeImageGenerator: " + drawFun.method());
        }
    }

    static class InfoImageGenerator extends ImageGenerator {
        public InfoImageGenerator(DrawFun drawFun) {
            super(drawFun);
        }

        @Override
        public void draw() {
            System.out.println("InfoImageGenerator: " + drawFun.method());
        }
    }
}

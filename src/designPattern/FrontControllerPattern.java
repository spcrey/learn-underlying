package designPattern;

public class FrontControllerPattern {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        FrontController frontController = new FrontController(dispatcher);
        frontController.dispatcherRequest("home");
        frontController.dispatcherRequest("student");
    }

    interface View {
        void show();
    }

    static class HomeView implements View {
        public void show() {
            System.out.println("HomeView Show");
        }
    }

    static class StudentView implements View {
        public void show() {
            System.out.println("StudentView Show");
        }
    }

    static class FrontController {
        Dispatcher dispatcher;
        public FrontController(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }
        public boolean isAuthenticUser() {
            System.out.println("check...");
            System.out.println("authentic successful");
            return true;
        }
        public void trackRequest(String request) {
            System.out.println("Page requested: " + request);
        }
        public void dispatcherRequest(String request) {
            trackRequest(request);
            if(isAuthenticUser()) {
                dispatcher.dispatch(request);
            }
        }
    }

    static class Dispatcher {
        private final View homeView;
        private final View studentView;

        public Dispatcher() {
            this.homeView = new HomeView();
            this.studentView = new StudentView();
        }

        public void dispatch(String request) {
            if(request.equals("home")) {
                homeView.show();
            }
            else if(request.equals("student")) {
                studentView.show();
            }
            else {
                throw new IllegalArgumentException("no view");
            }
        }
    }
}

package designPattern;

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterPattern {
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.addFilter(new AuthenticationFilter());
        filterManager.addFilter(new DebugFilter());
        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }

    interface Filter {
        void execute(String request);
    }

    static class AuthenticationFilter implements Filter {
        @Override
        public void execute(String request) {
            System.out.println("authenticating: " + request);
        }
    }

    static class DebugFilter implements Filter {
        @Override
        public void execute(String request) {
            System.out.println("request log: " + request);
        }
    }

    static class Target {
        public void execute(String request) {
            System.out.println("execute request: " + request);
        }
    }

    static class FilterChain {
        private final List<Filter> filters = new ArrayList<>();

        public void addFilter(Filter filter) {
            filters.add(filter);
        }

        public void execute(String request) {
            for(Filter filter: filters) {
                filter.execute(request);
            }
        }
    }

    static class FilterManager {
        private Target target;
        FilterChain filterChain;

        public FilterManager(Target target) {
            this.target = target;
            filterChain = new FilterChain();
        }

        public void addFilter(Filter filter) {
            filterChain.addFilter(filter);
        }

        public void execute(String request) {
            filterChain.execute(request);
            target.execute(request);
        }
    }

    static class Client {
        FilterManager filterManager;

        public void setFilterManager(FilterManager filterManager){
            this.filterManager = filterManager;
        }

        public void sendRequest(String request){
            filterManager.execute(request);
        }
    }
}

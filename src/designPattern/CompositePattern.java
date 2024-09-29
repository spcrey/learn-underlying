package designPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args){
        City china = new ComponentCity();
        City beijing = new LeafCity(300);
        china.add(beijing);
        City shandong = new ComponentCity();
        City qingdao = new LeafCity(500);
        shandong.add(qingdao);
        City jinan = new LeafCity(200);
        shandong.add(jinan);
        china.add(shandong);
        System.out.println(china.getPersonNum());
    }

    interface City {
        Integer getPersonNum();

        void add(City beijing);
    }

    static class LeafCity implements City {
        private final Integer personNum;

        public LeafCity(Integer personNum) {
            this.personNum = personNum;
        }

        @Override
        public Integer getPersonNum() {
            return personNum;
        }

        @Override
        public void add(City beijing) {
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }
    }

    static class ComponentCity implements City {
        List<City> cities = new ArrayList<>();
        public void add(City city) {
            cities.add(city);
        }
        @Override
        public Integer getPersonNum() {
            Integer sum = 0;
            for(City city: cities) {
                sum += city.getPersonNum();
            }
            return sum;
        }
    }
}


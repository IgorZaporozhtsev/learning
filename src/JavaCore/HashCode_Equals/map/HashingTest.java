package JavaCore.HashCode_Equals.map;

import java.util.HashMap;
import java.util.Map;

public class HashingTest {

    //run with equals and hashcode and without
    public static void main(String[] args) {
        Map<DataKey, Integer> hm = getAllData();

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println("dk.hashCode():-1 " + dk.hashCode());

        Integer value = hm.get(dk);

        System.out.println("value: " + value);

    }

    private static Map<DataKey, Integer> getAllData() {
        Map<DataKey, Integer> hm = new HashMap<>(2);

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println("dk.hashCode():-2 " + dk.hashCode());

        hm.put(dk, 10);

        return hm;
    }

    private static class DataKey {

        private String name;
        private int id;

        // getter and setter methods
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "DataKey [name=" + name + ", id=" + id + "]";
        }

      /*  @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;
            DataKey dataKey = (DataKey) obj;
            return Objects.equals(this.name, dataKey.name) && this.id == dataKey.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }*/
    }
}

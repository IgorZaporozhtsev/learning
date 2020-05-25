package JavaCore.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MainProgramPeople {
    public static void main(String[] args) {

        People people1 = new People(22, "Dima");
        People people2 = new People(32, "Oleg");
        People people3 = new People(12, "Igor");

        Map<String, Object> mapOfPeople = new HashMap();
        mapOfPeople.put("one", people1);
        mapOfPeople.put("too", people2);
        mapOfPeople.put("three", people3);

        for(Map.Entry<String, Object> pair : mapOfPeople.entrySet()){
            People value = (People) pair.getValue();
            System.out.println(value);
        }
    }
}

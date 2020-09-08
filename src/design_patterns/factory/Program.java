package design_patterns.factory;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {


        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("c++");

        for (String name : names) {
            DeveloperFactory developerFactory = createDeveloperFactoryBySpecialty(name);
            Developer developer = developerFactory.createDeveloper();
            developer.writeCode();
        }
    }

    static DeveloperFactory createDeveloperFactoryBySpecialty(String specialty){
        if(specialty.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("c++")){
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + "is unknow specialty...");
        }

    }

}

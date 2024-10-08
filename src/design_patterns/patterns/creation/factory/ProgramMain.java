package design_patterns.patterns.creation.factory;

public class ProgramMain {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpecialty("java");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    public static DeveloperFactory createDeveloperBySpecialty(String speciality){
        if (speciality.equals("java")){
            return new JavaDeveloperFactory();
        } else if (speciality.equals("c++")){
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException();
        }
    }

    interface DeveloperFactory{
        Developer createDeveloper();
    }

     private static class JavaDeveloperFactory implements DeveloperFactory{
        public Developer createDeveloper(){
            return new JavaDeveloper();
        }
    }

    private static class CppDeveloperFactory implements DeveloperFactory{
        public Developer createDeveloper(){
            return new CppDeveloper();
        }
    }

    interface Developer{
        void writeCode();
    }

    private static class JavaDeveloper implements Developer{

        @Override
        public void writeCode() {
            System.out.println("Write Java code ... ");
        }
    }

    private static class CppDeveloper implements Developer{

        @Override
        public void writeCode() {

            System.out.println("Write C++ code ... ");
        }
    }


}

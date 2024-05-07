package design_patterns.patterns.singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        System.out.println("Один и тот же экземпляр т.к одинаковые хеши" + "\n");
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString() + "\n");

        ProgramLogger.getProgramLogger().addLogIngo("First log....");
        ProgramLogger.getProgramLogger().addLogIngo("First second....");
        ProgramLogger.getProgramLogger().addLogIngo("First third....");

        ProgramLogger.getProgramLogger().showLogFile();
    }
}

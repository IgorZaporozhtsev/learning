package cources.stepic.base.ExeptionsTask;

public class Whence {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();

    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        String message = "";
            if (stackTraceElements.length < 3) {
                return null;
            }
            else {
                String className = stackTraceElements[2].getClassName();
                String methodName = stackTraceElements[2].getMethodName();
                message = className + "#" + methodName;
            }
        return message;
    }
}

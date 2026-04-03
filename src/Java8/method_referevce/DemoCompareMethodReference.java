package Java8.method_referevce;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class DemoCompareMethodReference {

	public static void main(String[] args) {
		//коли lambda - гегерує private static void Java8.method_referevce.DemoCompareMethodReference.lambda$main$0(java.lang.String)]
		// (INVOKEDYNAMIC посилається на lambda$main$0 новостворений метод)
		//коли method reference - не генерує (INVOKEDYNAMIC посилається на println)
		Consumer<String> stringConsumer = System.out::println;

		stringConsumer.accept("Hello");

		Method[] declaredMethods = DemoCompareMethodReference.class.getDeclaredMethods();
		System.out.println(Arrays.toString(declaredMethods));

	}
}

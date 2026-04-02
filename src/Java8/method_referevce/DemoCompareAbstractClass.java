package Java8.method_referevce;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class DemoCompareAbstractClass {

	public static void main(String[] args) {
		//compare with anonymous class by its bite code
		//create abstract сlass
		//Java8.method_referevce.DemoCompareAbstractClass$1
		Consumer<String> сonsumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};

		System.out.println(сonsumer.getClass().getName());

		//create static method
		//private static void lambda$main$0
//		Consumer<String> сonsumer = (s) -> System.out.println(s);

		Method[] declaredMethods = DemoCompareAbstractClass.class.getDeclaredMethods();
		System.out.println(Arrays.toString(declaredMethods));

		/*
		* також інструкція байткоду буди мати invokeDynamic коли буде використовуватись лабда
		* */
	}
}

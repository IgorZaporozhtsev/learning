package Java8.method_referevce;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Demo_Object_MethodName {

	public static void main(String[] args) {
		User currentUser = new User(19);
		AccessControlService service = new AccessControlService();
		//2.Object::instanceMethodName
		List<Resource> availableResources = service.getAvailableResources(currentUser, List.of());

		//2 and 3 together
		AccessControlService service1= new AccessControlService();
		Supplier<String> statusSupplier = service1::changeStatus;
		Function<AccessControlService, String> statusFunction = AccessControlService::changeStatus;

		String hello = "hello";
		Supplier<String> stringSupplier = hello::toUpperCase;
		Function<String, String> stringFunction = String::toUpperCase;
	}
}

class AccessControlService {

	//2. Object::instanceMethodName
	public List<Resource> getAvailableResources(User currentUser, List<Resource> allResources) {
		return allResources.stream()
			.filter(currentUser::hasAccessTo) // стан User визначає доступ
			.toList();
	}

	//2. Object::instanceMethodName
	public List<User> getSubordinates(User manager, List<User> allUsers) {
		return allUsers.stream()
			.filter(manager::isOlderThan)      // відносно конкретного User manager
			.sorted(Comparator.comparingInt(manager::getMiddleAge))
			.toList();
	}



	public String changeStatus(){
		return "Status changed".toUpperCase();
	}
}


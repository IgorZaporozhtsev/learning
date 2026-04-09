package Java8.method_referevce;

import java.util.Comparator;
import java.util.List;

public class Demo_Object_MethodName {

	public static void main(String[] args) {
		User currentUser = new User(19);
		AccessControlService service = new AccessControlService();
		List<Resource> availableResources = service.getAvailableResources(currentUser, List.of());

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
}


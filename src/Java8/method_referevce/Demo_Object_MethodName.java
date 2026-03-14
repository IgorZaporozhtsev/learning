package Java8.method_referevce;

import java.util.List;

public class Demo_Object_MethodName {

	public static void main(String[] args) {
		User currentUser = new User(19);
		AccessControlService service = new AccessControlService();
		List<Resource> availableResources = service.getAvailableResources(currentUser, List.of());

	}
}

class AccessControlService {

	public List<Resource> getAvailableResources(User currentUser, List<Resource> allResources) {
		return allResources.stream()
			.filter(currentUser::hasAccessTo) // стан currentUser визначає доступ
			.toList();
	}

	public List<User> getSubordinates(User manager, List<User> allUsers) {
		return allUsers.stream()
			.filter(manager::isOlderThan)      // відносно конкретного manager
			//.sorted(Comparator.comparingInt(manager::getAgeDifference))
			.toList();
	}
}


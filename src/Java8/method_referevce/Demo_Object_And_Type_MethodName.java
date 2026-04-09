package Java8.method_referevce;

import java.util.Optional;

public class Demo_Object_And_Type_MethodName {

	public static void main(String[] args) {

	}

	class JpaRoleRepository{

		private /*final*/ JpaRoleContainerRepository containerRepository;
		private /*final*/ JpaRoleExternalLinkRepository externalLinkRepository;


		public Optional<String> find(final String externalLink) {
			return
				externalLinkRepository
					.findById(externalLink)
					//тут ми працюємо з JpaRoleExternalLink який в стрімі, Type::methodName
					.map(JpaRoleExternalLink::roleId)
					//тут ми працюємо зі станом конкретного об'єкта тобто receiver'а (одержувача) тобто інстанса JpaRoleContainerRepository
					// Object::instanceMethodName
					.flatMap(containerRepository::findById)
					.map(JpaRoleContainer::role);
		}
	}

	interface JpaRoleContainerRepository{
		Optional<JpaRoleContainer> findById(String id);
	}
	interface JpaRoleExternalLinkRepository{
		Optional<JpaRoleExternalLink> findById(String id);
	}

	class JpaRoleExternalLink{
		public String roleId;

		private String roleId() { //getRoleId
			return roleId;
		}
	}
	class JpaRoleContainer{
		private String role;

		private String role() {
			return role;
		}
	}
}

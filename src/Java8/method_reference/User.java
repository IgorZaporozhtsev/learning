package Java8.method_reference;

class User {

	private final int age;
	private final Role role;
	private final Department department;

	public User(int age) {
		this.age = age;
		this.department = new Department();
		this.role = new Role();
	}

	public User(
		int age,
		Role role,
		Department department
	) {
		this.age = age;
		this.role = role;
		this.department = department;
	}

	public int getAge() {
		return this.age;
	}

	public int getMiddleAge(User user) {
		return this.getAge() + user.getAge() / 2;
	}

	public boolean isAdult() {
		return age > 18;
	}

	public boolean isReadyToWork(int age) {
		return age > 21;
	}

	public boolean isAdult(User user) {
		return user.getAge() < 18;
	}

	public boolean isYoungerThan(User other) {
		return other.getAge() < this.age; // this.age — стан admin'а reciver
	}

	public boolean hasAccessTo(Resource resource) {
		return this.role.canAccess(resource.getType())
			&& this.department == resource.getDepartment();
	}

	public boolean isOlderThan(User other) {
		return other.getAge() < this.age;
	}
}


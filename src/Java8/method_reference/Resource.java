package Java8.method_reference;

public class Resource {
	String type;
	Department department;

	private Resource(
		String type,
		Department department
	) {
		this.type = type;
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public Department getDepartment() {
		return department;
	}
}

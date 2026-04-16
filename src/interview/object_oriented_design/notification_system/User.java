package interview.object_oriented_design.notification_system;

import java.util.Set;

public class User{
	private String id;
	private String name;
	private Set<NotificationType> enabledChannels;

	public User(
		String id,
		String name,
		Set<NotificationType> enabledChannels
	) {
		this.id = id;
		this.name = name;
		this.enabledChannels = enabledChannels;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<NotificationType> getEnabledChannels() {
		return enabledChannels;
	}
}

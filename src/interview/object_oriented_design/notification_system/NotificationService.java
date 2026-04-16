package interview.object_oriented_design.notification_system;

import java.util.Map;

public class NotificationService {

	private final Map<NotificationType, Chanel> channels;

	public NotificationService(Map<NotificationType, Chanel> channels) {
		this.channels = channels;
	}

	public void notify(
		User user,
		Order order
	) {
		user.getEnabledChannels().forEach(chanelType -> {
			Chanel chanel = channels.get(chanelType);
			System.out.println("Sending notification to " + user.getName() + " via " + chanelType + " channel");
			chanel.send(order.toString());
		});
	}
}

package interview.object_oriented_design.notification_system;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoNotificationsSystem {

	public static void main(String[] args) {
		User user1 = new User("1", "Ihor", Set.of(NotificationType.ALERT, NotificationType.REMINDER));
		User user2 = new User("2", "Peter", Set.of(NotificationType.PROMOTION, NotificationType.REMINDER));
		User user3 = new User("3", "Derik", Set.of(NotificationType.PROMOTION, NotificationType.ALERT));

		OrderService orderService = new OrderService(
			new UserRepository() {
				@Override
				public List<User> findAll() {
					return List.of(user1, user2, user3);
				}
			},
			new NotificationService(
				Map.of(
					NotificationType.ALERT, new SMSService(),
					NotificationType.REMINDER, new PushService(),
					NotificationType.PROMOTION, new EmailService()
				)
			)
		);

		Order order = new Order();
		orderService.placeOrder(order);
	}
}

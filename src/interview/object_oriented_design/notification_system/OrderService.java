package interview.object_oriented_design.notification_system;

import java.util.PriorityQueue;

public class OrderService {

	PriorityQueue<Order> orderQueue = new PriorityQueue<>();
	private final UserRepository userRepository;
	private final NotificationService notificationService;

	public OrderService(
		UserRepository userRepository,
		NotificationService notificationService
	) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}

	public void placeOrder(Order order) {
		//save order
		//notify
		userRepository.findAll().forEach(user -> {
			notificationService.notify(user, order);
		});
	}
}

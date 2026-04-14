package design_patterns.head_first.observer.observer_task_1;

import design_patterns.head_first.observer.observer_task_1.solution.OrderObserver;

public class LoyaltyService implements OrderObserver {
	@Override
	public void onOrderPlaced(Order order) {
		int points = (int) (order.getTotalAmount() * 10);
		System.out.println("Awarded " + points + " loyalty points to " + order.getCustomerId());
	}
}

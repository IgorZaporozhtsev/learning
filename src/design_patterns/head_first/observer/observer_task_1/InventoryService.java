package design_patterns.head_first.observer.observer_task_1;

import design_patterns.head_first.observer.observer_task_1.solution.OrderObserver;

public class InventoryService implements OrderObserver {
	@Override
	public void onOrderPlaced(Order order) {
		System.out.println("Stock reserved for order " + order.getId());
	}
}

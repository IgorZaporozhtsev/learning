package design_patterns.head_first.observer.observer_task_1.solution;

import design_patterns.head_first.observer.observer_task_1.Order;

public interface OrderObserver {
	void onOrderPlaced(Order order);
}

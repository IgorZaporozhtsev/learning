package design_patterns.head_first.observer.observer_task_1;

import design_patterns.head_first.observer.observer_task_1.solution.OrderObserver;

public class AuditService implements OrderObserver {
	@Override
	public void onOrderPlaced(Order order) {
		System.out.println("AUDIT [ORDER_PLACED] order=" + order.getId()
			+ " customer=" + order.getCustomerId());
	}
}

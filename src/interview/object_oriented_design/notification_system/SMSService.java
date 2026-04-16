package interview.object_oriented_design.notification_system;

public class SMSService implements Chanel {

	private EmailClient client;

	@Override
	public void send(
		String message
	) {
		System.out.println("SMS sent to user");
		//client.sendEmail(message);
	}
}

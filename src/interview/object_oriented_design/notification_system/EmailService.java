package interview.object_oriented_design.notification_system;

public class EmailService implements Chanel {

	private EmailClient client;

	@Override
	public void send(
		String message
	) {
		System.out.println("Email sent to user");
		//client.sendEmail(message);
	}
}

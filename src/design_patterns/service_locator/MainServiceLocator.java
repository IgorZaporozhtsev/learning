package design_patterns.service_locator;

import java.util.ArrayList;
import java.util.List;

public class MainServiceLocator {
  public static void main(String[] args) {
    MessagingService service = ServiceLocator.getService("EmailService");
    String email = service.getMessageBody();
    System.out.println(email);

    MessagingService smsService
        = ServiceLocator.getService("SMSService");
    String sms = smsService.getMessageBody();
    System.out.println(sms);

    MessagingService emailService
        = ServiceLocator.getService("EmailService");
    String newEmail = emailService.getMessageBody();
    System.out.println(newEmail);
  }
}

interface MessagingService {
  String getMessageBody();
  String getServiceName();
}

class SMSService implements MessagingService {

  public String getMessageBody() {
    return "SMS message";
  }

  public String getServiceName() {
    return "SMSService";
  }
}

class EmailService implements MessagingService {
  public String getMessageBody() {
    return "email message";
  }

  public String getServiceName() {
    return "EmailService";
  }
}

class InitialContext {

  public Object lookup(String serviceName /*String jndiName*/) {
    if (serviceName.equalsIgnoreCase("EmailService")) {
      return new EmailService();
    } else if (serviceName.equalsIgnoreCase("SMSService")) {
      return new SMSService();
    }
    return null;
  }
}

class Cache {
  private List<MessagingService> services = new ArrayList<>();

  public MessagingService getService(String serviceName) {
    // retrieve from the list
    for (MessagingService service: services) {
      if (service.getServiceName().equalsIgnoreCase(serviceName)){
        System.out.println("Returning cached " + serviceName + " object");
        return service;
      }
    }
    return null;
  }

  public void addService(MessagingService newService) {
    // add to the list
    boolean exist = false;
    for (MessagingService service: services){
      if (service.getServiceName().equalsIgnoreCase(newService.getServiceName())){
        exist = true;
      }
    }
    if (!exist) {
      services.add(newService);
    }
  }
}

class ServiceLocator {
  private static Cache cache = new Cache();

  public static MessagingService getService(String serviceName) {

    MessagingService service = cache.getService(serviceName);

    if (service != null) {
      return service;
    }

    InitialContext context = new InitialContext();
    MessagingService service1 = (MessagingService) context.lookup(serviceName);
    cache.addService(service1);
    return service1;
  }
}
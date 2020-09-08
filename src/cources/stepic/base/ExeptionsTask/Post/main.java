package cources.stepic.base.ExeptionsTask.Post;

import java.util.logging.Logger;

public class main {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        MailMessage mailMessage = new MailMessage("Piter", "post", "УГРОЗА");

        Spy spy = new Spy(Logger.getLogger(MailMessage.class.getName()));
        spy.processMail(mailMessage);

        MailPackage mailPackage1 = new MailPackage("Johnny Depp", "Merry Poppins",new Package("Часы", 12) );
        Thief thief = new Thief(100);
        thief.processMail(mailPackage1);
        System.out.println(thief.getStolenValue());

        MailPackage mailPackage2 = new MailPackage("Jared Joseph Leto", "Fred Durst", new Package("Гитара", 1300));
        Inspector inspector = new Inspector();
        inspector.processMail(mailPackage2);

        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);



    }



}

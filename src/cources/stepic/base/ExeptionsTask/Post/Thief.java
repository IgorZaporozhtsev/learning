package cources.stepic.base.ExeptionsTask.Post;

public class Thief implements MailService {
    int minPrice;
    int stolenValue;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package myPackage = mailPackage.getContent();


            if (myPackage.getPrice() >= minPrice) {
                stolenValue += myPackage.getPrice();

                return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(),
                        new Package("stones instead of " + myPackage.getContent(), 0));
            }
        }
        return mail;
    }


}

package cources.stepic.base.ExeptionsTask.Post;

public class Inspector implements MailService {


    @Override
    public Sendable processMail(Sendable mail) {

        if(mail instanceof MailPackage){
            MailPackage mailPackage = (MailPackage) mail;

            if(mailPackage.getContent().getContent().contains("weapons") || mailPackage.getContent().getContent().contains("banned substance")){
               throw new IllegalPackageException();
            }
            else if(mailPackage.getContent().getContent().contains("stones")){
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}

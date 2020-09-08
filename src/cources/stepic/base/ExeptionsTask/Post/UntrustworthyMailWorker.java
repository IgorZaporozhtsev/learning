package cources.stepic.base.ExeptionsTask.Post;

/*
не надлежащий работник
*/

public class UntrustworthyMailWorker implements MailService {
    MailService [] mailServices;
    RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker (MailService [] mailServices){
        this.mailServices = mailServices;

    }


    public RealMailService getRealMailService(){
        return realMailService;
    }


    @Override
    public Sendable processMail (Sendable mail)  {


        for (int i = 0; i < mailServices.length ; i++) {
            mail = mailServices[i].processMail(mail);
        }

        return getRealMailService().processMail(mail);
    }



}

package refactoring.ifelse_refactoring.issue;


// https://www.youtube.com/watch?v=9hD2rh3PXvM&ab_channel=MJC

public class MessageSender {
    private static final int TYPE_PERSONAL = 0;
    private static final int TYPE_BUSINESS = 1;
    private static final int TYPE_APOLOGY = 2;
    private static final int TYPE_CUSTOMER = 3;

    private void sendMail(){
        int emailTemplateCode = MessageSenderUtil.getTemplateTypeCodeFromDB();

        String emailTemplateAsString = "";

        if(emailTemplateCode == TYPE_PERSONAL){
            emailTemplateAsString = getPersonalTemplateMessage();
        } else if (emailTemplateCode == TYPE_BUSINESS){
            emailTemplateAsString = getBusinessTemplateMessage();
        } else if (emailTemplateCode == TYPE_APOLOGY){
            emailTemplateAsString = getApologyTemplateMessage();
        } else if (emailTemplateCode == TYPE_CUSTOMER) {
            emailTemplateAsString = getCustomerTemplateMessage();
        }

        MessageSenderUtil.sendMessage(emailTemplateAsString);
    }

    private String getBusinessTemplateMessage() {
        return "It is business message";
    }

    private String getPersonalTemplateMessage() {
        return "Hi today is perfect day";
    }

    private String getApologyTemplateMessage() {
        return "apology";
    }

    private String getCustomerTemplateMessage() {
        return "customer message";
    }
}

package refactoring.ifelse_refactoring.solution_1;

import refactoring.ifelse_refactoring.issue.MessageSenderUtil;

public class MessageSender {

    private void sendEmail(){
        int emailTemplateCode = MessageSenderUtil.getTemplateTypeCodeFromDB();

        String template = MessageType.getTemplateByCode(emailTemplateCode).mailTemplate().getTemplate();
        MessageSenderUtil.sendMessage(template);

    }
}

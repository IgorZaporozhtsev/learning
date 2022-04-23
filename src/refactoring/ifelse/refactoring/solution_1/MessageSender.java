package refactoring.ifelse.refactoring.solution_1;

import refactoring.ifelse.refactoring.issue.MessageSenderUtil;

public class MessageSender {

    private void sendEmail(){
        int emailTemplateCode = MessageSenderUtil.getTemplateTypeCodeFromDB();

        String template = MessageType.getTemplateByCode(emailTemplateCode).mailTemplate().getTemplate();
        MessageSenderUtil.sendMessage(template);

    }
}

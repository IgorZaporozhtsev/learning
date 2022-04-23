package refactoring.ifelse.refactoring.solution_1;

import java.util.function.Supplier;

public enum MessageType {
    PERSONAL(0, new PersonalMailTemplate()),
    BUSINESS(1, new BusinessMailTemplate());

    private final int typeCode;
    private final MailTemplate mailTemplate;


    MessageType(int typeCode, MailTemplate mailTemplate) {
        this.typeCode = typeCode;
        this.mailTemplate = mailTemplate;
    }

    public static MessageType getTemplateByCode(int code){
        for(MessageType type: MessageType.values()){
            if (type.typeCode == code){
                return type;
            }
        }
    throw new RuntimeException("There is ni such message type");
    }

    public MailTemplate mailTemplate() {
        return mailTemplate;
    }


}

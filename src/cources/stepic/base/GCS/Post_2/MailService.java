package cources.stepic.base.GCS.Post_2;

import java.util.*;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<Sendable <T>> {



    private Map<String, List<T>> mailbox= new HashMap<String, List<T>>();

    List<T>list = new ArrayList<>();



    public Map<String, List <T>> getMailBox() {
        return mailbox;
    }



    @Override
    public void accept(Sendable<T> tSendable) {

        // должен принимать объект  Sendable<T>
        List<T> list;

        if (mailbox.containsKey(tSendable.getTo())){
            List <T> resoult = mailbox.get(tSendable.getTo());
            resoult.add(tSendable.getContent());
            mailbox.put(tSendable.getTo(),resoult);

        }
        else
        {
            list =  new ArrayList<>();
            list.add(tSendable.getContent());
            mailbox.put(tSendable.getTo(),list);
        }

        // если майлбокс содержит уже этот ключ, мы достаем значение
        // и добавляем туда контент если нет создаем новый лист и кладем в майлбокс
        // новый лист




    }


}

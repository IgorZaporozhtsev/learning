package cources.stepic.base.ExeptionsTask.Post;
/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/

public interface MailService {
    Sendable processMail(Sendable mail) ;
}

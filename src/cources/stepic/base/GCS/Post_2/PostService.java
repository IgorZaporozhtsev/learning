package cources.stepic.base.GCS.Post_2;

import java.util.*;

public class PostService {
    public static void main(String[] args) {


        // Random variables
        String randomFrom = "Hi"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "Hi";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.


        // Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece," +
                        " Howard!");


        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!");

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар.");


        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";


        List<MailMessage> messages = Arrays.asList(firstMessage, secondMessage, thirdMessage);

        //////////////////////////////////////////////////////////////////

        List <String> list = new ArrayList<>();
        Map <String, List <String>> map = new HashMap<>();

        list.add(firstMessage.getContent());
        map.put(firstMessage.getTo(), list);

        List <String> list1 = map.get(firstMessage.getTo());
        List <String> list2 = map.get("H.P. Lovecraft");

/////////////////////////////////////////////////////////////////

// Создание почтового сервиса.

        MailService<String> mailService = new MailService<String>();

// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService); // Integer or String???

// Получение и проверка словаря "почтового ящика",
// где по получателю можно получить список сообщений, которые были ему отправлены

        Map<String, List<String>> mailBox = mailService.getMailBox(); // тут String ??????????????????????

        assert mailBox.get("H.P. Lovecraft").
                equals(Arrays.asList("This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!")) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").

                equals(Arrays.asList("Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!", "Я так и не понял Интерстеллар.")
                ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


        // Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE); // :)
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.

        Map<String, List<Integer>> salaries = salaryService.getMailBox(); // тут Integer
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }

}

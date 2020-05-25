package cources.stepic.base.base.Tsikli;

//ПЬЕСА

public class Scene2410 {

    public static void main(String[] args) {
        String [] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филипович",
                "Лука Лукич"
        };

        String [] textLines = {
                 "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\n",
                 "Аммос Федорович: Как ревизор?\n",
                 "Артемий Филипович: Как ревизор?\n",
                 "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\n",
                 "Аммос Федорович: Вот те на!\n",
                 "Артемий Филипович: Вот не было заботы, так подай!\n",
                 "Лука Лукич: Господи боже! еще и с секретным предписаньем!\n"
        };

                                                                           // епта...
        Scene2410 scene = new Scene2410();
        System.out.println(scene.printTextPerRole(roles, textLines));

    }

/*
* Нужно призвести соеденение строк определив начальные буквы используя индексы
* Пробегаемся циклом и сравниеваем индексы Допустим Городничему принадлежат индексы №1 и №4
*
* */
    
    private String printTextPerRole(String[] roles, String[] textLines) {


        StringBuilder builder = new StringBuilder();

       for (int i = 0; i < roles.length; i++) {

           builder.append(roles[i]+":\n");
            for (int j = 0; j < textLines.length; j++) {

                if (textLines[j].startsWith(roles[i]+":")){

                    builder.append((j+1+")")+textLines[j].replaceFirst(roles[i]+":", "")+"\n");
                }
            }

           builder.append("\n");
       }

       return builder.toString();
    }
}

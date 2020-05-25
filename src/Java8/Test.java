package Java8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class Test {

    public static void main(String args[]) {


        String expected = "gmail.com=[Account(id=1, firstName=Justin, lastName=Butler, email=justin.butler@gmail.com, birthday=2003-04-17, sex=MALE, creationDate=2016-06-13, balance=172966), Account(id=3, firstName=Nolan, lastName=Donovan, email=nolandonovan@gmail.com, birthday=1925-04-19, sex=MALE, creationDate=2011-03-10, balance=13889)], mail.com=[Account(id=2, firstName=Olivia, lastName=Cardenas, email=cardenas@mail.com, birthday=1930-01-19, sex=FEMALE, creationDate=2014-06-21, balance=38029)], yahoo.com=[Account(id=4, firstName=Lucas, lastName=Lynn, email=lucas.lynn@yahoo.com, birthday=1987-05-25, sex=MALE, creationDate=2009-03-05, balance=16980)]";
        String mail2 = "Account(id=1, firstName=Justin, lastName=Butler, email=justin.butler@gmail.com, birthday=2003-04-17, sex=MALE, creationDate=2016-06-13, balance=172966), Account(id=2, firstName=Olivia, lastName=Cardenas, email=cardenas@mail.com, birthday=1930-01-19, sex=FEMALE, creationDate=2014-06-21, balance=38029), Account(id=3, firstName=Nolan, lastName=Donovan, email=nolandonovan@gmail.com, birthday=1925-04-19, sex=MALE, creationDate=2011-03-10, balance=13889), Account(id=4, firstName=Lucas, lastName=Lynn, email=lucas.lynn@yahoo.com, birthday=1987-05-25, sex=MALE, creationDate=2009-03-05, balance=16980)";


        String[] arrOfStr = mail2.split("@");
        //System.out.println(Arrays.toString(arrOfStr));

        foo(arrOfStr[1]);

        //for (String a : arrOfStr)
        // System.out.println(a);
    }


    public static  void foo (String str){
        System.out.println(str);
    }

}

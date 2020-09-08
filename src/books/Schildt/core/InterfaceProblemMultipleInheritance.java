package books.Schildt.core;

public class InterfaceProblemMultipleInheritance {

    public static void main(String[] args) {


    }

}
//Case 1 ERROR
/*interface Alpha{
    default String reset(){
      return "Alpha";
    }
}

interface Beta {
    default String reset(){
        return "Beta";
    }
}

class MyClass implements Beta, Alpha{

}*/

//Case 2 use only Beta implemetation reset()
/*
interface Alpha{
    default String reset(){
        return "Alpha";
    }
}

interface Beta extends Alpha{
    default String reset(){
        return "Beta";
    }
}

class MyClass implements Beta{

}
*/
//Case 3 use only MyClass implemetation reset()


interface Alpha{
    default String reset(){
        return "Alpha";
    }
}

interface Beta{
    default String reset(){
        return "Beta";
    }
}

class MyClass implements Beta, Alpha{
    @Override
    public String reset() {
        return null;
    }
}

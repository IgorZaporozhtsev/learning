package IoC.DI;

//этот класс без DI тоесть класс Speaker отвечает и за сам процесс речи но и за саму речь!
// Каждый должен заниматься своим делом

public class Speaker {
    private HelloSpeakWriter writer = new HelloSpeakWriter();

    public void speak(){
        System.out.println(writer.getSpeak());
    }
}

class HelloSpeakWriter{
    public String getSpeak(){
        return "Hello";
    }
}

class GoSpeakWriter{
    public String getSpeak(){
        return "Go Go Go";
    }
}

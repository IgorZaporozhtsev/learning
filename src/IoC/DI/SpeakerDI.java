package IoC.DI;

public class SpeakerDI {
    private SpeakerWriter speakerWriter;

    public SpeakerDI(SpeakerWriter speakerWriterInterface) {
        // передаем в параментры конструктора интерфейс через который можно создавать экземпляры
        // GoSpeakWriterDI и HelloSpeakWriterDI
        this.speakerWriter = speakerWriterInterface;
    }

    public void speak(){
        System.out.println(speakerWriter.getSpeak());
    }

    public static void main(String[] args) {
        SpeakerDI di = new SpeakerDI(new GoSpeakWriterDI());
        di.speak();

    }
}
//----------------------------------------------------------------------------------------------------------------------
interface SpeakerWriter{
    public String getSpeak();
}

//----------------------------------------------------------------------------------------------------------------------
class HelloSpeakWriterDI implements SpeakerWriter{

    @Override
    public String getSpeak(){
        return "Hello";
    }
}

//----------------------------------------------------------------------------------------------------------------------
class GoSpeakWriterDI implements SpeakerWriter{

    @Override
    public String getSpeak(){
        return "Go Go Go";
    }

}

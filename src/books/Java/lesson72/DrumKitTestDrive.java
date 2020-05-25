package books.Java.lesson72;

/**
 * Created by Igor on 15.12.2016.
 */
public class DrumKitTestDrive {

    public static void main(String[] args) {



        DrumKit d = new DrumKit(); //создаем объект с названием класса к кторому хоти достучатся
        d.playSnare(); // подключаемся к медтоду другого класса через ссылку d
        d.snare = false;

        d.playTopHat();
        if (d.snare == true) d.playSnare();



    }
}

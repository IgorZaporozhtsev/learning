package Java8.functional_interface.supplier;

import Java8.prepared_data.Hobby;
import Java8.prepared_data.HobbyType;
import Java8.prepared_data.PersonStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SuppliersExample_1 {
    public static void main(String[] args) {
        PersonStream person = generatePersonStream();
        show(personStream -> System.out.println(person.getFirst_name()), person);
    }

    private static void show(Consumer<PersonStream> personStreamConsumer, PersonStream person) {
        personStreamConsumer.andThen(personStreamConsumer).accept(person);
    }

    public static PersonStream generatePersonStream() {
        Hobby chessHobby = new Hobby("chess", 7, HobbyType.INTELLIGENCE);

        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(chessHobby);

        return new PersonStream("Rick", "Rickerson", "ingenneer", 43, hobbies);
    }

}

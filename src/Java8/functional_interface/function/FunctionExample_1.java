package Java8.functional_interface.function;

import Java8.prepared_data.HobbyStream;
import Java8.prepared_data.HobbyType;
import Java8.prepared_data.PersonStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static Java8.functional_interface.supplier.SuppliersExample_1.generatePersonStream;

public class FunctionExample_1 {
    public static void main(String[] args) {

        PersonStream person = generatePersonStream();

        List<PersonStream> list = new ArrayList<>();
        list.add(person);

    }

}

class Foo {

    public List<? extends HobbyStream> fooHobbies(List<PersonStream> personStreams) {
        Function<PersonStream, HobbyStream> fooMethod = personStream -> fooMethod(personStream);
        return build(personStreams, fooMethod);
    }

    public List<? extends HobbyStream> hooHobbies(List<PersonStream> personStreams) {
        return build(personStreams, this::hooMethod);
    }


    public List<? extends HobbyStream> build(List<PersonStream> persons, Function<PersonStream, HobbyStream> function) {
        return persons.stream()
            .map(function)
            .collect(Collectors.toList());
    }

    public HobbyStream fooMethod(PersonStream personStream) {
        return new HobbyStream("chess", 7, HobbyType.INTELLIGENCE);
    }

    public HobbyStream hooMethod(PersonStream personStream) {
        return new HobbyStream("chess", 7, HobbyType.INTELLIGENCE);
    }
}

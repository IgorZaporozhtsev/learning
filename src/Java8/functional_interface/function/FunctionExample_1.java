package Java8.functional_interface.function;

import Java8.prepared_data.Hobby;
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

    public List<? extends Hobby> fooHobbies(List<PersonStream> personStreams) {
        Function<PersonStream, Hobby> fooMethod = personStream -> fooMethod(personStream);
        return build(personStreams, fooMethod);
    }

    public List<? extends Hobby> hooHobbies(List<PersonStream> personStreams) {
        return build(personStreams, this::hooMethod);
    }


    public List<? extends Hobby> build(List<PersonStream> persons, Function<PersonStream, Hobby> function) {
        return persons.stream()
            .map(function)
            .collect(Collectors.toList());
    }

    public Hobby fooMethod(PersonStream personStream) {
        return new Hobby("chess", 7, HobbyType.INTELLIGENCE);
    }

    public Hobby hooMethod(PersonStream personStream) {
        return new Hobby("chess", 7, HobbyType.INTELLIGENCE);
    }
}

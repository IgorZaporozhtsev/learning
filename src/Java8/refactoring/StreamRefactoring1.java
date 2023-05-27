package Java8.refactoring;

import Java8.refactoring.data.Child;
import Java8.refactoring.data.Parent;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamRefactoring1 {

/*

  public List<Child> collectionChildrenByAge(List<Parent> parents){
        return parents.stream()
                .map(Parent::getChildren)
                .flatMap(Collection::stream)
                .filter(olderThen18YearsOld())
                .distinct()
                .toList();
    }


    public List<Child> collectionChildrenByName(List<Parent> parents){
        return parents.stream()
                .map(Parent::getChildren)
                .flatMap(Collection::stream)
                .filter(withSpecificName())
                .distinct()
                .toList();
    }

*/

    //can use only this one instead above two
    public List<Child> collectionPredicate(List<Parent> parents, Predicate<Child> childPredicate){
        return parents.stream()
                .map(Parent::getChildren)
                .flatMap(Collection::stream)
                .filter(childPredicate)
                .distinct()
                .toList();
    }

    public void run(List<Parent> parents) {

        //1. use method predicates
        collectionPredicate(parents, byAge(18));
        collectionPredicate(parents, byName("Alex"));

        //2. we can use chain of predicates
        collectionPredicate(parents, byAge(18).and(byAge(20)));  //and
        collectionPredicate(parents, byAge(18).or(byAge(20)));   //or
        collectionPredicate(parents, byAge(18).negate());   //negate
        collectionPredicate(parents, byAge(18).and(byName("Sam")));

        //3. we can use method reference
        Function<Integer, Predicate<Child>> byAge2 = age -> child -> child.getAge() >= age;
        Function<String, Predicate<Child>> byName2 = name -> child -> name.equals(child.getFirstName());

        collectionPredicate(parents, byAge2.apply(18).and(byName2.apply("Alex")));
    }

    private Predicate<Child> byName(String name) {
        return child -> child.getFirstName().equals(name);
    }

    private Predicate<Child> byAge(int age) {
        return child -> child.getAge() >= age;
    }

}

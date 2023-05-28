package Java8.refactoring;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StreamRefactoring2 {


//    public List<String> process(String param){
//        validate(transform(createModel(param)));
//    }

    public List<String> process(String param){
        return first(createModel)
                .andThen(transform)
                .andThen(validate)
                .apply(param);
    }

    private Function<String, BussinesObject> createModel =  name ->  new BussinesObject(name);
    private UnaryOperator<BussinesObject> transform =  bussinesObject -> new BussinesObject("Sam");
    private Function<BussinesObject, List<String>> validate = bussinesObject -> List.of(bussinesObject.getFirstName());


    public <K, V> Function<K, V> first(Function<K, V> function){
        return function;
    }

    class BussinesObject{
        String firstName;

        public BussinesObject() {
        }

        public BussinesObject(String firstName) {
            this.firstName = firstName;
        }

        public BussinesObject(BussinesObject bussinesObject) {

        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }
}

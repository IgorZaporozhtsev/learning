package refactoring.dto_mapper_func_style;

import java.util.Arrays;
import java.util.List;

public class UserRepo {

    public List<User> findAll() {
        return Arrays.asList(new User(), new User(), new User());
    }
}

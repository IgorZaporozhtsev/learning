package refactoring.functional.style;

import java.util.Arrays;
import java.util.List;

public class UserRepo {

    public List<User> findAll() {
        return Arrays.asList(new User(), new User(), new User());
    }
}

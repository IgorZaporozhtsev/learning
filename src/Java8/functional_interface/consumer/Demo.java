package Java8.functional_interface.consumer;

import Java8.prepared_data.User;

import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {

        //Modifying Object Properties
        //Use Consumer to update or modify fields in objects.

        Consumer<User> setAdminRole = user -> user.setName("Admin" + user.getName());
        User user = new User("1", "John");
        setAdminRole.accept(user);
        System.out.println(user.getName());

    }
}

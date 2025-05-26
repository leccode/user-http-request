import user.User;
import user.UserClient;

import java.io.IOException;
import java.util.List;

/**
 * This class is used to demonstrate
 * the workflow of HTTP request from
 * {JSON} Placeholder provider for user
 * data. It includes the GET service, and
 * the record class that maps the response
 * to a list (User).
 *
 * @since 26/05/2025
 * @author Constantine Lekkos
 */
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Instance of the service for the users
        UserClient userClient = new UserClient();

        // Object of List<User> type is used to save the result of the method
        List<User> users = userClient.getAll();

        // Users are represented as objects rather than strings
        for (var user : users) {
            System.out.println(user);
        }
    }
}

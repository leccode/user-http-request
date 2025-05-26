package user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * The Service that gets the users
 * from the given end point.
 */
public class UserClient {
    // The base URL, and the end point of the API call
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    /**
     * The constructor that
     * injects the above
     * services.
     */
    public UserClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    /**
     * The actual request method
     * for the users API call.
     * @return the response and maps it with the User model
     * @throws IOException
     * @throws InterruptedException
     */
    public List<User> getAll() throws IOException, InterruptedException {
        // GET Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        // Request's Response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Returns the body of the response mapped in the record User class
        return objectMapper.readValue(response.body(), new TypeReference<>() {});
    }
}

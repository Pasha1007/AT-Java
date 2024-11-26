package task16;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task16 {
    ObjectMapper objectMapper = new ObjectMapper();

    void createBoard() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                .uri(new URI("https://api.trello.com/1/boards/?name=newBoard&key&token"))
                .headers("Accept","application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(200, response.statusCode());
    }
}

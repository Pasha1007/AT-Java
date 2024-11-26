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
                .uri(new URI("https://api.trello.com/1/boards/?name=newBoard&key=a43a95e7ae1c1fc5ee3cff80c698297b&token=ATTA421024049c6817beb71e7831ac94cce2e1971ff657af78024c1b298d87b980835EA1C637"))
                .headers("Accept","application/json")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        Assert.assertEquals(200, response.statusCode());
    }
}

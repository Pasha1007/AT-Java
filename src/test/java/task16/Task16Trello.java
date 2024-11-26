package task16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;

public class Task16Trello {
//    private static final String APIKEY = "a43a95e7ae1c1fc5ee3cff80c698297b";
//    private static final String TOKEN = "ATTA421024049c6817beb71e7831ac94cce2e1971ff657af78024c1b298d87b980835EA1C637";
   @Test
    void createBoard(){
       Response createBoardRes = given()
               .queryParam("name","NewBoard2")
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/boards")
               .then().assertThat().statusCode(200)
               .extract()
               .response();
       String boardId = createBoardRes.jsonPath().getString("id");

       Response createListRes = given()
               .queryParam("name","NewList")
               .queryParam("idBoard", boardId)
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/lists")
               .then().assertThat().statusCode(200).extract().response();
       String listId = createListRes.jsonPath().getString("id");

       Response createCardRes = given()
               .queryParam("idList", listId)
               .queryParam("name","created card")
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/cards")
               .then().assertThat().statusCode(200).extract().response();
       String cardId = createCardRes.jsonPath().getString("id");

       Response createCheckListRes = given()
               .queryParam("idCard", cardId)
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/checklists")
               .then().assertThat().statusCode(200).extract().response();
       String checkListId = createCheckListRes.jsonPath().getString("id");

       given()
               .queryParam("name","do something")
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/checklists/"+ checkListId +"/checkItems")
               .then().assertThat().statusCode(200);

       given()
               .queryParam("name","new name")
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .put("https://api.trello.com/1/checklists/"+ checkListId)
               .then().assertThat().statusCode(200);

       given()
               .queryParam("key", APIKEY)
               .queryParam("token", TOKEN)
               .header("Accept", "application/json").contentType(ContentType.JSON)
               .when()
               .delete("https://api.trello.com/1/checklists/"+ checkListId)
               .then().assertThat().statusCode(200);

   }
//   @Test
//   void compareTest() throws URISyntaxException, IOException, InterruptedException {
//       Task16 t1 = new Task16();
//       t1.createBoard();
//   }
}

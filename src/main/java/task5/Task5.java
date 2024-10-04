//V6
//{
//    "title": "Meeting with team",
//        "date": "2023-03-01",
//        "description": "Discuss project status with team members"
//}
//<meeting>
//<title>Meeting with team</title>
//  <date>2023-03-01</date>
//<description>Discuss project status with team members</description>
//</meeting>
//

//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.


package task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class Task5 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Meeting meeting = null;
        try {
            meeting = objectMapper.readValue(Files.readString(new File("/Users/pashakramar/IdeaProjects/PracticeJava1/src/main/resources/input.json").toPath()), Meeting.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(meeting.toString());
        meeting.setTitle("new title");
        meeting.setDescription(UUID.randomUUID().toString());
        System.out.println(meeting.toString());

        try {
            objectMapper.writeValue(new File("/Users/pashakramar/IdeaProjects/PracticeJava1/src/main/resources/output.json"), meeting);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

package task5;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

//{
//    "title": "Meeting with team",
//        "date": "2023-03-01",
//        "description": "Discuss project status with team members"
//}


public class Meeting implements Serializable {
  String title;
  Date date;
  String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}

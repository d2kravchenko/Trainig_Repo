package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostModel {

    private int userId, id;
    private String title, body;

    public PostModel(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}

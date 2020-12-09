package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MPost {

    private int userId, id;
    private String title, body;

    public MPost(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}

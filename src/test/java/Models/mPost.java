package Models;

import lombok.*;

@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class mPost {

    private int userId, id;
    private String title, body;

    public mPost(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}

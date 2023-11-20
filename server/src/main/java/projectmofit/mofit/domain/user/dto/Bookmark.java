package projectmofit.mofit.domain.user.dto;

import lombok.Data;

@Data
public class Bookmark {

    private int userId;
    private String videoId;
    private String thumbnails;

    public Bookmark() {
    }

    public Bookmark(int userId, String videoId, String thumbnails) {
        this.userId = userId;
        this.videoId = videoId;
        this.thumbnails = thumbnails;
    }
}

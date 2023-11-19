package projectmofit.mofit.domain.gallery.dto;

import lombok.Data;

@Data
public class CommentGallery {
    private int commentIdx;
    private int galleryIdx;
    private String content;
    private int writer;
    private String date;
    private String nickname;
}

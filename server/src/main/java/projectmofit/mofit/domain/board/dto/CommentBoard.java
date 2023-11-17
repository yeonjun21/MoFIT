package projectmofit.mofit.domain.board.dto;

import lombok.Data;

@Data
public class CommentBoard {
    private int commentIdx;
    private int boardIdx;
    private String content;
    private int writer;
    private String date;
    private String nickname;
}

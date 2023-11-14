package projectmofit.mofit.domain.board.dto;

import lombok.Data;

@Data
public class CommentBoard {
    private int index;
    private int groupId;
    private String content;
    private int writer;
    private String date;
}

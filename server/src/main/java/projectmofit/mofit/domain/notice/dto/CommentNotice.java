package projectmofit.mofit.domain.notice.dto;

import lombok.Data;

@Data
public class CommentNotice {
    private int commentIdx;
    private int noticeIdx;
    private String title;
    private String content;
    private int writer;
    private String date;
    private String nickname;
}

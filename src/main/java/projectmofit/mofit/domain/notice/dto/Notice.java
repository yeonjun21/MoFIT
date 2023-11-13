package projectmofit.mofit.domain.notice.dto;

import lombok.Data;

@Data
public class Notice {
    private int index;
    private int groupId;
    private String title;
    private String content;
    private int writer;
    private int date;
}

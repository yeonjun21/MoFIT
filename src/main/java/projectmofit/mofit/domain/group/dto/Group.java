package projectmofit.mofit.domain.group.dto;

import lombok.Data;

@Data
public class Group {

    private int groupId;
    private String groupName;
    private String type;
    private String info;

    // private String profileImg;
    // private String coverImg;
}

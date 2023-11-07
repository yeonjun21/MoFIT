package projectmofit.mofit.domain.group.dto;

import lombok.Data;
import java.util.List;

@Data
public class Group {

    private int groupId;
    private String groupName;
    private String type;
    private String info;
    private List<String> regions;

    // private String profileImg;
    // private String coverImg;
}

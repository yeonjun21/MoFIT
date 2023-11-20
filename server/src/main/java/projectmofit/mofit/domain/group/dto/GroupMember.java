package projectmofit.mofit.domain.group.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GroupMember {
    private int groupId;
    private int userId;
    private String nickname;
    private String grade;
}

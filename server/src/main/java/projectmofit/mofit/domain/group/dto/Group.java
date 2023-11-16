package projectmofit.mofit.domain.group.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class Group {

    private int groupId;

    @NotBlank(message = "모임 이름을 입력하세요.")
    @Size(max = 20, message = "모임 이름은 최대 20자까지 입력 가능합니다.")
    private String groupName;

    @NotBlank(message = "운동 종목을 선택하세요.")
    private String type;

    @NotBlank(message = "모임 소개글을 입력하세요.")
    @Size(max = 300, message = "모임 소개글은 최대 300자까지 입력 가능합니다.")
    private String info;

    @Size(min = 1, message = "활동 지역을 1개 이상 선택하세요.")
    private List<String> regions;

    // private String profileImg;
    // private String coverImg;

    private int leaderId;
}

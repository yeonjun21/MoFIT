package projectmofit.mofit.domain.user.service;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface MyPageService {

    List<Group> getMyGroups(int id);

    List<Integer> getMyLeaderGroups(int id);
}

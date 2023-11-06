package projectmofit.mofit.domain.group.service;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface GroupService {

    void createGroup(Group group);

    List<Group> getGroupByRegion(String region);
}

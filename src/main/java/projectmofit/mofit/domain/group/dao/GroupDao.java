package projectmofit.mofit.domain.group.dao;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface GroupDao {
    int insertGroup(Group group);

    List<Group> findGroupByRegion(String region);
}

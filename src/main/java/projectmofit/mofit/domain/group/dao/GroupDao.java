package projectmofit.mofit.domain.group.dao;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface GroupDao {
    int insertGroup(Group group);

    int insertRegion(String groupName, String region);

    List<Group> findGroupByRegion(String region);

    List<String> findRegions(int groupId);
}

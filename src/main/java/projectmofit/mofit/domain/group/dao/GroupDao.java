package projectmofit.mofit.domain.group.dao;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface GroupDao {
    int insertGroup(Group group);

    int insertRegion(String groupName, String region);

    int groupNameCheck(String groupName);

    Group findGroupById(int groupId);

    Group findGroupByGroupName(String groupName);

    List<Group> findGroupByRegion(String region);

    List<String> findRegions(int groupId);

    void insertGroupLeader(int userId, int groupId);

    int joinGroup(int userId, int groupId);
}

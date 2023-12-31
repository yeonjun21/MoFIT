package projectmofit.mofit.domain.group.dao;

import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.dto.GroupHomeDto;
import projectmofit.mofit.domain.group.dto.GroupMember;
import projectmofit.mofit.domain.user.dto.User;

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

    GroupHomeDto findGroupDetail(int groupId);

    List<GroupMember> findGroupMember(int groupId);

    void deleteMember(int groupId, int userId);
}

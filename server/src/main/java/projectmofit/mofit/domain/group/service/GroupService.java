package projectmofit.mofit.domain.group.service;

import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.dto.GroupHomeDto;
import projectmofit.mofit.domain.group.dto.GroupMember;

import java.util.List;

public interface GroupService {

    void addGroup(Group group);

    void addRegion(String groupName, String region);

    void addGroupLeader(int userId, String groupName);

    int join(int userId, int groupId);

    int groupNameCheck(String groupName);

    Group getGroupById(int groupId);

    List<Group> getGroupByRegion(String region);

    List<String> getRegions(int groupId);

    GroupHomeDto getGroupDetail(int groupId);

    List<GroupMember> getGroupMember(int groupId);
}

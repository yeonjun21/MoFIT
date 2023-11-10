package projectmofit.mofit.domain.group.service;

import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

public interface GroupService {

    void addGroup(Group group);

    void addRegion(String groupName, String region);

    int groupNameCheck(String groupName);

    Group getGroupById(int groupId);

    List<Group> getGroupByRegion(String region);

    List<String> getRegions(int groupId);
}

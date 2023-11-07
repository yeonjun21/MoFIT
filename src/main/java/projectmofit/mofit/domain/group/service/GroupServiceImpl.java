package projectmofit.mofit.domain.group.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.group.dao.GroupDao;
import projectmofit.mofit.domain.group.dto.Group;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    @Override
    public void addGroup(Group group) {
        groupDao.insertGroup(group);
    }

    @Override
    public void addRegion(String groupName, String region) {
        groupDao.insertRegion(groupName, region);
    }

    @Override
    public List<Group> getGroupByRegion(String region) {
        return groupDao.findGroupByRegion(region);
    }

    @Override
    public List<String> getRegions(int groupId) {
        return groupDao.findRegions(groupId);
    }
}

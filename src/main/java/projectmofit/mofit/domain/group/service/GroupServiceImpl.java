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
    public void createGroup(Group group) {
        groupDao.insertGroup(group);
    }

    @Override
    public List<Group> getGroupByRegion(String region) {
        return groupDao.findGroupByRegion(region);
    }
}

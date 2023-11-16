package projectmofit.mofit.domain.group.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.group.dao.GroupDao;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.dto.GroupHomeDto;

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
    public void addGroupLeader(int userId, String groupName) {
        int groupId = groupDao.findGroupByGroupName(groupName).getGroupId();
        groupDao.insertGroupLeader(userId, groupId);
    }

    @Override
    public int join(int userId, int groupId) {
        return groupDao.joinGroup(userId, groupId);
    }

    @Override
    public int groupNameCheck(String groupName) {
        return groupDao.groupNameCheck(groupName);
    }

    @Override
    public Group getGroupById(int groupId) {
        return groupDao.findGroupById(groupId);
    }

    @Override
    public List<Group> getGroupByRegion(String region) {
        List<Group> list = groupDao.findGroupByRegion(region);

        // 리스트에 있는 모임에 해당 모임의 활동 지역 넣어주기
        // 모임의 활동 지역을 저장하는 테이블이 따로 있으므로 넣어주는 작업 필요
        for (Group group : list) {
            List<String> regions = groupDao.findRegions(group.getGroupId());
            group.setRegions(regions);
        }
        return list;
    }

    @Override
    public List<String> getRegions(int groupId) {
        return groupDao.findRegions(groupId);
    }

    @Override
    public GroupHomeDto getGroupDetail(int groupId) {
        return groupDao.findGroupDetail(groupId);
    }
}

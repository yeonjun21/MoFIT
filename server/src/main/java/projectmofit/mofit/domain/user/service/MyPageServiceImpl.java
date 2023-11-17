package projectmofit.mofit.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.group.dao.GroupDao;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.user.dao.MyPageDao;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

    private final MyPageDao myPageDao;
    private final GroupDao groupDao;

    @Override
    public List<Group> getMyGroups(int id) {
        List<Group> list = myPageDao.findMyGroup(id);
        List<Integer> leaderList = myPageDao.findMyLeaderGroup(id);

        // 해당 회원이 운영진인 모임에는 leaderId 필드 넣어주기
        for (Group group : list) {
            if (leaderList.contains(group.getGroupId())) {
                group.setLeaderId(id);
            }
        }
        return list;
    }

    @Override
    public List<Integer> getMyLeaderGroups(int id) {
        return myPageDao.findMyLeaderGroup(id);
    }
}

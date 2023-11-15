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
        return myPageDao.findMyGroup(id);
    }
}

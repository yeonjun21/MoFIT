package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.group.dto.Group;

import java.util.List;

public interface MyPageDao {

    List<Group> findMyGroup(int id);

    List<Integer> findMyLeaderGroup(int id);

}

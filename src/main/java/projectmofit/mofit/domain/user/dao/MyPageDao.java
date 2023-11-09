package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.group.dto.Group;

import java.util.List;

public interface MyPageDao {

    List<Group> findMyGroup(int id);

    // 찜한 영상 가져오기
//    List<Video> findMyVideo(int id);

}

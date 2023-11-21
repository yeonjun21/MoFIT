package projectmofit.mofit.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.user.dao.FollowDao;
import projectmofit.mofit.domain.user.dto.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowDao followDao;

    @Override
    public boolean follow(int followerId, int followingId) {
        return followDao.follow(followerId, followingId) > 0;
    }

    @Override
    public boolean unfollow(int followerId, int followingId) {
        return followDao.unfollow(followerId, followingId) > 0;
    }

    @Override
    public List<User> getFollowers(int id) {
        return followDao.getFollowers(id);
    }

    @Override
    public List<User> getFollowings(int id) {
        return followDao.getFollowings(id);
    }

    @Override
    public boolean followCheck(int id, int other) {
        return followDao.followCheck(id, other) > 0;
    }
}

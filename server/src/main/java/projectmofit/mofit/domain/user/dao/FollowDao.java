package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.user.dto.User;

import java.util.List;

public interface FollowDao {

    int follow(int followerId, int followingId);

    int unfollow(int followerId, int followingId);

    List<User> getFollowers(int id);

    List<User> getFollowings(int id);

    int followCheck(int id, int other);
}

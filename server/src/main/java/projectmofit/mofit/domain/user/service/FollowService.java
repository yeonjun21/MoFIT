package projectmofit.mofit.domain.user.service;

import projectmofit.mofit.domain.user.dto.User;

import java.util.List;

public interface FollowService {

    boolean follow(int followerId, int followingId);

    boolean unfollow(int followerId, int followingId);

    List<User> getFollowers(int id);

    List<User> getFollowings(int id);

    boolean followCheck(int id, int other);

}

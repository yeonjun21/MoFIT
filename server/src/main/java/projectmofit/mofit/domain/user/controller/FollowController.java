package projectmofit.mofit.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.FollowService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class FollowController {

    private final FollowService followService;

    // 팔로우
    @PostMapping("/follow")
    public ResponseEntity<Void> follow(@RequestParam int followerId, @RequestParam int followingId) {
        if (followService.follow(followerId, followingId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 언팔로우
    @PostMapping("/unfollow")
    public ResponseEntity<Void> unfollow(@RequestParam int followerId, @RequestParam int followingId) {
        if (followService.unfollow(followerId, followingId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 내 팔로워 목록
    @GetMapping("/{id}/follower")
    public List<User> followerList(@PathVariable int id) {
        return followService.getFollowers(id);
    }

    // 내 팔로잉 목록
    @GetMapping("/{id}/following")
    public List<User> followingList(@PathVariable int id) {
        return followService.getFollowings(id);
    }

    // 특정 회원을 팔로우 하는지 여부 확인
    @GetMapping("/follow-check")
    public boolean followCheck(@RequestParam int id, @RequestParam int other) {
        return followService.followCheck(id, other);
    }
}

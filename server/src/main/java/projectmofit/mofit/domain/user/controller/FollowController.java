package projectmofit.mofit.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.FollowService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class FollowController {

    private final FollowService followService;

    // TODO 팔로우, 언팔로우

    // 내 팔로워 목록
    @GetMapping("/{id}/follower")
    public String followerList(@PathVariable int id, Model model) {
        List<User> followers = followService.getFollowers(id);

        if (followers != null && followers.size() > 0) {
            model.addAttribute("followers", followers);
        }

        return "";
    }

    // 내 팔로잉 목록
    @GetMapping("/{id}/following")
    public String followingList(@PathVariable int id, Model model) {
        List<User> followings = followService.getFollowings(id);

        if (followings != null && followings.size() > 0) {
            model.addAttribute("followings", followings);
        }

        return "";
    }
}

package projectmofit.mofit.domain.user.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.group.dao.GroupDao;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.MyPageService;
import projectmofit.mofit.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;

    //내 모임 조회

    // 마이페이지 조회
    // TODO 본인 페이지만 조회 가능해야
    @GetMapping("/{id}")
    public String myPage(@PathVariable int id, Model model) {
        // 내가 가입한 모임 넣어주기
        List<Group> myGroup = myPageService.getMyGroups(id);
        model.addAttribute("myGroup", myGroup);

        // TODO 모임 회원 등급도 같이 보이게!

        // TODO 내가 쓴 글 넣어주기
        // TODO 내가 찜한 영상 넣어주기
        // TODO 팔로워, 팔로잉 수 넣어주기

        return "user/myPage";
    }

}

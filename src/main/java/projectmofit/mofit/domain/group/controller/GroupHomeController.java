package projectmofit.mofit.domain.group.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.service.GroupService;
import projectmofit.mofit.domain.user.dto.User;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupHomeController {

    private final GroupService groupService;

    // 모임 Home
    @GetMapping("/{groupId}")
    public String groupHome(@PathVariable int groupId, Model model) {
        Group group = groupService.getGroupById(groupId);
        List<String> regions = groupService.getRegions(groupId);
        group.setRegions(regions);
        model.addAttribute("group", group);

        // TODO 현재 회원이 모임에 가입했는지 여부 확인
        // 모임에 가입하지 않은 경우에만 '모임 가입하기' 버튼 띄우기

        return "group/groupHome";
    }

    // 해당 모임 가입하기
    // TODO 바로 가입될지, 아니면 가입 신청 메세지를 운영진에게 보낼지
    @PostMapping("/{groupId}")
    public String join(@PathVariable int groupId, HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");

        if (groupService.join(loginUser.getId(), groupId) > 0) {
            model.addAttribute("result", "가입이 완료되었습니다.");
        };

        Group group = groupService.getGroupById(groupId);
        List<String> regions = groupService.getRegions(groupId);
        group.setRegions(regions);
        model.addAttribute("group", group);

        return "group/groupHome";
    }
}

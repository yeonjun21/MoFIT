package projectmofit.mofit.domain.group.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.service.GroupService;
import java.util.List;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    // 특정 동네의 모임 리스트 보기
    @GetMapping("/{region}")
    public String regionGroupList(@PathVariable String region, Model model) {
        List<Group> list = groupService.getGroupByRegion(region);
        model.addAttribute("list", list);
        model.addAttribute("region", region);
        return "index";
    }

}

package projectmofit.mofit.domain.group.controller;


import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.service.GroupService;

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
        return "group/groupHome";
    }
}

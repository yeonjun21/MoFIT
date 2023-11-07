package projectmofit.mofit.domain.group.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    private static List<String> regions = new ArrayList<>();

    private static List<String> types = new ArrayList<>();

    static {
        regions.add("강남구"); regions.add("강동구"); regions.add("강북구");
        regions.add("강서구"); regions.add("관악구"); regions.add("광진구");
        regions.add("구로구"); regions.add("금천구"); regions.add("노원구");
        regions.add("도봉구"); regions.add("동대문구"); regions.add("동작구");
        regions.add("마포구"); regions.add("서대문구"); regions.add("서초구");
        regions.add("성동구"); regions.add("성북구"); regions.add("송파구");
        regions.add("양천구"); regions.add("영등포구"); regions.add("용산구");
        regions.add("은평구"); regions.add("종로구"); regions.add("중구");
        regions.add("중랑구");

        types.add("러닝"); types.add("등산"); types.add("축구");
        types.add("골프"); types.add("헬스"); types.add("수영");
        types.add("농구"); types.add("자전거"); types.add("테니스");
        types.add("배드민턴"); types.add("클라이밍"); types.add("기타");
    }

    // 특정 동네의 모임 리스트 보기
    @GetMapping("/{region}")
    public String regionGroupList(@PathVariable String region, Model model) {
        List<Group> list = groupService.getGroupByRegion(region);

        // 리스트에 있는 모임에 해당 모임의 활동 지역 넣어주기
        // 모임의 활동 지역을 저장하는 테이블이 따로 있으므로 넣어주는 작업 필요
        for (Group group : list) {
            List<String> regions = groupService.getRegions(group.getGroupId());
            group.setRegions(regions);
        }

        model.addAttribute("list", list);
        model.addAttribute("region", region);
        return "index";
    }

    @GetMapping
    public String addGroupForm(@ModelAttribute Group group, Model model) {
        model.addAttribute("regions", regions);
        model.addAttribute("types", types);
        return "group/addGroupForm";
    }

    // 모임 만들기
    @PostMapping
    public String addGroup(@ModelAttribute Group group) {
        groupService.addGroup(group);

        for (String region : group.getRegions()) {
            groupService.addRegion(group.getGroupName(), region);
        }
        return "index";
    }

}

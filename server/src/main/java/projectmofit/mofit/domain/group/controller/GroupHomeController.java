package projectmofit.mofit.domain.group.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.dto.GroupHomeDto;
import projectmofit.mofit.domain.group.service.GroupService;
import projectmofit.mofit.domain.user.dto.User;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupHomeController {

    private final GroupService groupService;

    // 모임 Home
    @GetMapping("/{groupId}")
    public Group groupHome(@PathVariable int groupId) {
        Group group = groupService.getGroupById(groupId);
        List<String> regions = groupService.getRegions(groupId);
        group.setRegions(regions);

        // byte[] -> base64
        byte[] arr = group.getByteImg();
        if(arr != null && arr.length > 0){
            String base64Encode = byteToBase64(arr);
            base64Encode = "data:image/png;base64," + base64Encode;
            group.setImg(base64Encode);
        }
        return group;
    }

    // 모임 멤버 수, 게시글 수, 리더 닉네임 가져오기
    @GetMapping("/{groupId}/detail")
    public GroupHomeDto groupHomeDetail(@PathVariable int groupId) {
        return groupService.getGroupDetail(groupId);
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

    // byte[] -> base64
    private static String byteToBase64(byte[] arr){
        String result = "";
        try {
            result = Base64.getEncoder().encodeToString(arr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

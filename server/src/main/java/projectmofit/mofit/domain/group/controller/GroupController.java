package projectmofit.mofit.domain.group.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.dto.GroupMember;
import projectmofit.mofit.domain.group.service.GroupService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    // 모임 만들기
    @PostMapping
    public ResponseEntity<Void> addGroup(@Valid @RequestBody Group group, BindingResult bindingResult) {
        // 모임 이름 중복 확인
        if (groupService.groupNameCheck(group.getGroupName()) > 0) {
            bindingResult.rejectValue("groupName", "duplication", "이미 사용 중인 모임 이름입니다.");
        }

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // 모임 프로필 등록
        byte[] imgArr = null;
        // TODO jpeg 말고 다른 확장자도 가능하게 하기
        final String BASE_64_PREFIX = "data:image/jpeg;base64,";
        try {
            String base64url = group.getImg();
            if (base64url.startsWith(BASE_64_PREFIX)) {
                imgArr = Base64.getDecoder().decode(base64url.substring(BASE_64_PREFIX.length()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        group.setByteImg(imgArr);

        // 새 모임 생성
        groupService.addGroup(group);

        // 모임에 활동 지역 추가(테이블이 달라서 따로 넣어줘야 함)
        for (String region : group.getRegions()) {
            groupService.addRegion(group.getGroupName(), region);
        }

        // 모임 운영자 정보 추가
        int leaderId = group.getLeaderId();
        groupService.addGroupLeader(leaderId, group.getGroupName());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 모임 이름 중복 확인
    @GetMapping("/groupNameCheck")
    public ResponseEntity<Void> groupNameCheck(@RequestParam String groupName) {
        if (groupService.groupNameCheck(groupName) > 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 특정 동네의 모임 리스트 보기
    @GetMapping("/list")
    public List<Group> regionGroupList(@RequestParam String region) {
        List<Group> list = groupService.getGroupByRegion(region);

        // 리스트에 있는 모임에 해당 모임의 활동 지역 넣어주기
        // 모임의 활동 지역을 저장하는 테이블이 따로 있으므로 넣어주는 작업 필요
        for (Group group : list) {
            List<String> regions = groupService.getRegions(group.getGroupId());
            group.setRegions(regions);
        }

        // 모든 리스트의 byteImg를 base64로 변환후 img 필드에 담아준다.
        for(Group group : list){
            byte[] arr = group.getByteImg();
            if(arr != null && arr.length > 0){
                String base64Encode = byteToBase64(arr);
                base64Encode = "data:image/png;base64," + base64Encode;
                group.setImg(base64Encode);
            }
        }
        return list;
    }

    // 특정 모임의 멤버 리스트
    @GetMapping("/{groupId}/member")
    public List<GroupMember> member(@PathVariable int groupId) {
        return groupService.getGroupMember(groupId);
    }

    // 모임 가입하기
    @PostMapping("/{groupId}/member")
    public ResponseEntity<Void> join(@PathVariable int groupId, @RequestParam int userId) {
        if (groupService.join(userId, groupId) > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 모임 탈퇴
    @GetMapping("/{groupId}/member/delete")
    public void withdraw(@PathVariable int groupId, @RequestParam int userId) {
        System.out.println(groupId);
        System.out.println(userId);
        groupService.withdraw(groupId, userId);
    }


    @GetMapping("/regions")
    public List<String> regions() {
        List<String> regions = new ArrayList<>();
        regions.add("강남구"); regions.add("강동구"); regions.add("강북구");
        regions.add("강서구"); regions.add("관악구"); regions.add("광진구");
        regions.add("구로구"); regions.add("금천구"); regions.add("노원구");
        regions.add("도봉구"); regions.add("동대문구"); regions.add("동작구");
        regions.add("마포구"); regions.add("서대문구"); regions.add("서초구");
        regions.add("성동구"); regions.add("성북구"); regions.add("송파구");
        regions.add("양천구"); regions.add("영등포구"); regions.add("용산구");
        regions.add("은평구"); regions.add("종로구"); regions.add("중구");
        regions.add("중랑구");
        return regions;
    }

//    @ModelAttribute("types")
    @GetMapping("/types")
    public List<String> types() {
        List<String> types = new ArrayList<>();
        types.add("러닝"); types.add("등산"); types.add("축구");
        types.add("골프"); types.add("헬스"); types.add("수영");
        types.add("농구"); types.add("자전거"); types.add("테니스");
        types.add("배드민턴"); types.add("클라이밍"); types.add("기타");
        return types;
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

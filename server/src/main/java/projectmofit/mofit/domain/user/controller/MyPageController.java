package projectmofit.mofit.domain.user.controller;

import lombok.RequiredArgsConstructor;

import java.util.Base64;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.board.service.BoardService;
import projectmofit.mofit.domain.group.dto.Group;
import projectmofit.mofit.domain.group.service.GroupService;
import projectmofit.mofit.domain.user.dto.User;
import projectmofit.mofit.domain.user.service.MyPageService;
import projectmofit.mofit.domain.user.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService myPageService;
    private final GroupService groupService;
    private final UserService userService;
    private final BoardService boardService;

    // 회원 정보 가져오기
    @GetMapping("/{id}")
    public User userInfo(@PathVariable int id) {
        return userService.findById(id);
    }

    // 내가 가입한 운동 모임 리스트
    @GetMapping("/{id}/group")
    public List<Group> myGroup(@PathVariable int id) {
        // 내가 가입한 모임 리스트
        List<Group> list = myPageService.getMyGroups(id);

        // 리스트에 있는 모임에 해당 모임의 활동 지역 넣어주기
        for (Group group : list) {
            List<String> regions = groupService.getRegions(group.getGroupId());
            group.setRegions(regions);
        }

        for(Group group : list){
            byte[] arr = group.getByteImg();
            if(arr != null && arr.length > 0){
                String base64Encode = byteToBase64(arr);
                base64Encode = "data:image/jpeg;base64," + base64Encode;
                group.setImg(base64Encode);
            }
        }

        return list;
    }

    // 내가 쓴 글 리스트
    @GetMapping("/{userId}/board")
    public List<Board> myBoard(@PathVariable int userId) {
        return boardService.getBoardByUserId(userId);
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

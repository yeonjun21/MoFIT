package projectmofit.mofit.domain.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.board.dto.Board;

@Controller
@RequestMapping("/group")
public class BoardController {
    //인터셉터가 접근을 막기 때문에 groupId만 받는다
    @GetMapping("/{groupId}/notice")
    public String list(@PathVariable int groupId, @PathVariable String userId){
        return null;
    }
    //deltail form에서 index를 날려줌
    @GetMapping("/{groupId}/notice")
    public String detail(@PathVariable int groupId , int index){

        return null;
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping("/notice")
    public String write(Board board){

        return null;
    }

    //detailform -> editform -> 새로운 board가 들어옴
    @PostMapping("/notice/edit")
    public String edit(Board board){

        return null;
    }

    @PostMapping("/{groupId}/notice/delete")
    public String delete(@PathVariable int groupId, int index){

        return null;
    }

    //updateForm, writeForm 따로 구현하기!!
    //정보 가져온 뒤 -> 리다이렉트
}

package projectmofit.mofit.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.board.dto.CommentBoard;
import projectmofit.mofit.domain.board.service.CommentBoardService;

import java.util.List;

@RestController
@RequestMapping("/board/comment")
@RequiredArgsConstructor
public class CommentBoardController {

    private final CommentBoardService commentBoardService;

    @GetMapping
    public ResponseEntity<List<CommentBoard>> list(@RequestParam int boardIdx){
        System.out.println(boardIdx);
        List<CommentBoard> list = commentBoardService.getComment(boardIdx);
        System.out.println(list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping
    public ResponseEntity<?> write(@RequestBody CommentBoard commentBoard){
        int result = commentBoardService.addComment(commentBoard);
        if(result==0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //임시로 index 와 date로 엮어 놓음
    @PutMapping
    public ResponseEntity<Void> edit(@RequestBody CommentBoard commentBoard){
        System.out.println(commentBoard);
        commentBoardService.editComment(commentBoard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping //수정 필요함 db에서 유일한 댓글을 찾을 수 없음 임시로 index
    public ResponseEntity<Void> delete(@RequestParam int commentIdx){
        System.out.println(commentIdx);
        int result = commentBoardService.removeComment(commentIdx);
        if(result == 0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

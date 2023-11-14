package projectmofit.mofit.domain.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.notice.dto.CommentNotice;
import projectmofit.mofit.domain.notice.service.CommentNoticeService;

import java.util.List;

@RestController
@RequestMapping("/notice/comment")
@RequiredArgsConstructor
public class CommentNoticeController {
    private final CommentNoticeService commentNoticeService;

    @GetMapping
    public ResponseEntity<List<CommentNotice>> list(@RequestParam int index){
        List<CommentNotice> list = commentNoticeService.getComment(index);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping
    public ResponseEntity<?> write(CommentNotice commentNotice){
        int result = commentNoticeService.addComment(commentNotice);
        if(result==0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //임시로 index 와 date로 엮어 놓음
    @PutMapping
    public ResponseEntity<Void> edit(CommentNotice commentNotice){
        commentNoticeService.editComment(commentNotice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping //수정 필요함 db에서 유일한 댓글을 찾을 수 없음 임시로 index
    public ResponseEntity<Void> delete(@RequestParam int index){
        int result = commentNoticeService.removeComment(index);
        if(result == 0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

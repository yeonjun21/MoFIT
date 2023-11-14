package projectmofit.mofit.domain.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectmofit.mofit.domain.notice.dto.Notice;
import projectmofit.mofit.domain.notice.service.NoticeService;

import java.util.List;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam int groupId){
        List<Notice> list = noticeService.getNotice(groupId);
        if(list.size()==0){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Notice>>(list, HttpStatus.OK);
    }
    //deltail form에서 index를 날려줌
    @GetMapping("/{index}")
    public ResponseEntity<?> detail(@RequestParam int index){
        Notice notice = noticeService.getNoticeByGroupId(index);
        if(notice==null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(notice, HttpStatus.OK);
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping
    public ResponseEntity<?> write(Notice notice){
        int result = noticeService.addNotice(notice);
        if(result==0){
            return new ResponseEntity<Void>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //detailform -> editform -> 새로운 board가 들어옴
    @PutMapping
    public ResponseEntity<Void> edit(Notice notice){
        noticeService.editNotice(notice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int index){
        noticeService.removeComment(index);
        int result = noticeService.removeNotice(index);
        if(result==0){
            return new ResponseEntity<>(HttpStatus.INSUFFICIENT_STORAGE);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

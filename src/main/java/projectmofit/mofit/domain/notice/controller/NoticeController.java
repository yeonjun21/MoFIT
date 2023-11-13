package projectmofit.mofit.domain.notice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projectmofit.mofit.domain.notice.dto.Notice;
import projectmofit.mofit.domain.notice.service.NoticeService;

import java.util.List;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/{groupId}/notice")
    public String list(@PathVariable int groupId, Model model){
        List<Notice> list = noticeService.getNotice(groupId);
        model.addAttribute("list",list);
        return null;
    }
    //deltail form에서 index를 날려줌
    @GetMapping("/{groupId}/notice/{index}")
    public String detail(@PathVariable int groupId , @PathVariable int index, Model model){
        Notice notice = noticeService.getNoticeByGroupId(groupId, index);
        model.addAttribute("notice",notice);
        return null;
    }

    //글 등록시 프론트에서 전부 채워서 들어옴
    @PostMapping("/notice")
    public String write(Notice notice){
        int result = noticeService.addNotice(notice);
        if(result==0){

        }
        return null;
    }

    //detailform -> editform -> 새로운 board가 들어옴
    @PostMapping("/notice/edit")
    public String edit(Notice notice){
        noticeService.editNotice(notice);
        return null;
    }

    @PostMapping("/{groupId}/notice/delete")
    public String delete(@PathVariable int groupId, int index){
        noticeService.removeNotice(groupId, index);
        return null;
    }

    //updateForm, writeForm 따로 구현하기!!
    //정보 가져온 뒤 -> 리다이렉트

}

package projectmofit.mofit.domain.notice.service;

import projectmofit.mofit.domain.board.dto.CommentBoard;
import projectmofit.mofit.domain.notice.dto.CommentNotice;

import java.util.List;

public interface CommentNoticeService {

    List<CommentNotice> getComment(int index);
    int addComment(CommentNotice commentNotice);
    void editComment(CommentNotice commentNotice);
    int removeComment(int index);
}

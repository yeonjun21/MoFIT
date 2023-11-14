package projectmofit.mofit.domain.notice.dao;

import projectmofit.mofit.domain.notice.dto.CommentNotice;

import java.util.List;

public interface CommentNoticeDao {
    List<CommentNotice> selectAll(int noticeIdx);
    int insertComment(CommentNotice commentNotice);
    void updateComment(CommentNotice commentNotice);
    int deleteComment(int commentIdx);
}

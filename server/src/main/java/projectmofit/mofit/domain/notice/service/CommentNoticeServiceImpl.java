package projectmofit.mofit.domain.notice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.notice.dao.CommentNoticeDao;
import projectmofit.mofit.domain.notice.dto.CommentNotice;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentNoticeServiceImpl implements CommentNoticeService{

    private final CommentNoticeDao commentNoticeDao;
    @Override
    public List<CommentNotice> getComment(int index) {
        return commentNoticeDao.selectAll(index);
    }

    @Override
    public int addComment(CommentNotice commentNotice) {
        return commentNoticeDao.insertComment(commentNotice);
    }

    @Override
    public void editComment(CommentNotice commentNotice) {
        commentNoticeDao.updateComment(commentNotice);
    }
    //유일한 댓글이 없음
    @Override
    public int removeComment(int index) {
        return commentNoticeDao.deleteComment(index);
    }
}

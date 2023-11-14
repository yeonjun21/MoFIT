package projectmofit.mofit.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.board.dao.CommentBoardDao;
import projectmofit.mofit.domain.board.dto.CommentBoard;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentBoardServiceImpl implements CommentBoardService{

    private final CommentBoardDao commentBoardDao;
    @Override
    public List<CommentBoard> getComment(int boardIdx) {
        return commentBoardDao.selectAll(boardIdx);
    }

    @Override
    public int addComment(CommentBoard commentBoard) {
        return commentBoardDao.insertComment(commentBoard);
    }

    @Override
    public void editComment(CommentBoard commentBoard) {
        commentBoardDao.updateComment(commentBoard);
    }
    //유일한 댓글이 없음
    @Override
    public int removeComment(int commentIdx) {
        return commentBoardDao.deleteComment(commentIdx);
    }
}

package projectmofit.mofit.domain.board.dao;

import projectmofit.mofit.domain.board.dto.CommentBoard;

import java.util.List;

public interface CommentBoardDao {
    List<CommentBoard> selectAll(int index);
    int insertComment(CommentBoard commentBoard);
    void updateComment(CommentBoard commentBoard);
    int deleteComment(int index);
}

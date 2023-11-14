package projectmofit.mofit.domain.board.dao;

import projectmofit.mofit.domain.board.dto.CommentBoard;

import java.util.List;

public interface CommentBoardDao {
    List<CommentBoard> selectAll(int boardIdx);
    int insertComment(CommentBoard commentBoard);
    void updateComment(CommentBoard commentBoard);
    int deleteComment(int commentIdx);
}

package projectmofit.mofit.domain.board.dao;

import projectmofit.mofit.domain.board.dto.Board;

import java.util.List;

public interface BoardDao {
    List<Board> selectAll(int groupId);
    List<Board> selectByUserId(int userId);
    Board selectOne(int index);
    int insertBoard(Board board);
    void updateBoard(Board board);
    int deleteBoard(int index);
    int deleteComment(int index);
}

package projectmofit.mofit.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.board.dao.BoardDao;
import projectmofit.mofit.domain.board.dto.Board;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;

    @Override
    public List<Board> getBoard(int groupId) {
        List<Board> list = boardDao.selectAll(groupId);
        return list;
    }

    @Override
    public Board getBoardByGroupId(int index) {
        Board board = boardDao.selectOne(index);
        return board;
    }

    @Override
    public int addBoard(Board board) {
        int result = boardDao.insertBoard(board);
        return result;
    }

    @Override
    public void editBoard(Board board) {
        boardDao.updateBoard(board);
    }

    @Override
    public int removeBoard(int index) {
        int result = boardDao.deleteBoard(index);
        return result;
    }

    @Override
    public void removeComment(int index) {
        boardDao.deleteComment(index);
    }

    @Override
    public List<Board> getBoardByUserId(int userId) {
        return boardDao.selectByUserId(userId);
    }
}

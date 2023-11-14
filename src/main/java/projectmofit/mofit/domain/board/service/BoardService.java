package projectmofit.mofit.domain.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.board.dao.BoardDao;
import projectmofit.mofit.domain.board.dto.Board;

import java.util.List;


public interface BoardService {
    List<Board> getBoard(int groupId);
    Board getBoardByGroupId(int index);
    int addBoard(Board board);
    void editBoard(Board board);
    int removeBoard(int index);

}

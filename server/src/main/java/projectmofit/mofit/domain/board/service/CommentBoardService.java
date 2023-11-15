package projectmofit.mofit.domain.board.service;

import projectmofit.mofit.domain.board.dto.CommentBoard;

import java.util.List;

public interface CommentBoardService {

    List<CommentBoard> getComment(int index);
    int addComment(CommentBoard commentBoard);
    void editComment(CommentBoard commentBoard);
    int removeComment(int index);
}

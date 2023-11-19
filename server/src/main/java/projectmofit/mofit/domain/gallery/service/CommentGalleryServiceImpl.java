package projectmofit.mofit.domain.gallery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.board.dao.CommentBoardDao;
import projectmofit.mofit.domain.board.dto.CommentBoard;
import projectmofit.mofit.domain.board.service.CommentBoardService;
import projectmofit.mofit.domain.gallery.dao.CommentGalleryDao;
import projectmofit.mofit.domain.gallery.dto.CommentGallery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentGalleryServiceImpl implements CommentGalleryService {

    private final CommentGalleryDao commentGalleryDao;
    @Override
    public List<CommentGallery> getComment(int galleryIdx) {
        return commentGalleryDao.selectAll(galleryIdx);
    }

    @Override
    public int addComment(CommentGallery commentGallery) {
        return commentGalleryDao.insertComment(commentGallery);
    }

    @Override
    public void editComment(CommentGallery commentGallery) {
        commentGalleryDao.updateComment(commentGallery);
    }
    //유일한 댓글이 없음
    @Override
    public int removeComment(int commentIdx) {
        return commentGalleryDao.deleteComment(commentIdx);
    }
}

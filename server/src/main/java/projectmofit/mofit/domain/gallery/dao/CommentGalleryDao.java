package projectmofit.mofit.domain.gallery.dao;

import projectmofit.mofit.domain.gallery.dto.CommentGallery;

import java.util.List;

public interface CommentGalleryDao {
    List<CommentGallery> selectAll(int galleryIdx);
    int insertComment(CommentGallery commentGallery);
    void updateComment(CommentGallery commentGallery);
    int deleteComment(int commentIdx);
}

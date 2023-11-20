package projectmofit.mofit.domain.gallery.service;

import projectmofit.mofit.domain.gallery.dto.CommentGallery;
import projectmofit.mofit.domain.gallery.dto.Gallery;

import java.util.List;

public interface CommentGalleryService {

    List<CommentGallery> getComment(int index);
    int addComment(CommentGallery commentGallery);
    void editComment(CommentGallery commentGallery);
    int removeComment(int index);
}

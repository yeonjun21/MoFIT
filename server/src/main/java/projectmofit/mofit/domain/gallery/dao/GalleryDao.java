package projectmofit.mofit.domain.gallery.dao;

import projectmofit.mofit.domain.gallery.dto.Gallery;

import java.util.List;

public interface GalleryDao {

    List<Gallery> selectAll(int groupId);
    Gallery selectOne(int index);
    int insertImg(Gallery gallery);
    void updateGallery(Gallery gallery);
    int deleteGallery(int index);
    void deleteComment(int index);

}

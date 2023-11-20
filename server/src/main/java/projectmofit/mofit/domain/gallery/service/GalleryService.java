package projectmofit.mofit.domain.gallery.service;

import projectmofit.mofit.domain.gallery.dto.Gallery;

import java.util.List;

public interface GalleryService {

    List<Gallery> getGallery(int groupId);
    Gallery getImgByIndex(int index);
    int addImg(Gallery gallery);
    void editGallery(Gallery gallery);
    int removeGallery(int index);
    void removeComment(int index);
}

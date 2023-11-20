package projectmofit.mofit.domain.gallery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.gallery.dao.GalleryDao;
import projectmofit.mofit.domain.gallery.dto.Gallery;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService{

    private final GalleryDao galleryDao;

    @Override
    public List<Gallery> getGallery(int groupId) {
        List<Gallery> list = galleryDao.selectAll(groupId);
        return list;
    }

    @Override
    public Gallery getImgByIndex(int index) {
        return galleryDao.selectOne(index);
    }

    @Override
    public int addImg(Gallery gallery) {
        return galleryDao.insertImg(gallery);
    }

    @Override
    public void editGallery(Gallery gallery) {
        galleryDao.updateGallery(gallery);
    }

    @Override
    public int removeGallery(int index) {
        int result = galleryDao.deleteGallery(index);
        return result;
    }

    @Override
    public void removeComment(int index) {
        galleryDao.deleteComment(index);
    }
}

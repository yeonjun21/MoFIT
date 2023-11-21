package projectmofit.mofit.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.user.dao.BookmarkDao;
import projectmofit.mofit.domain.user.dto.Bookmark;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkDao bookmarkDao;

    @Override
    public int bookmark(Bookmark bookmark) {
        return bookmarkDao.bookmark(bookmark);
    }

    @Override
    public List<Bookmark> getBookmark(int userId) {
        return bookmarkDao.findBookmark(userId);
    }

    @Override
    public int deleteBookmark(Bookmark bookmark) {
        return bookmarkDao.deleteBookmark(bookmark);
    }
}

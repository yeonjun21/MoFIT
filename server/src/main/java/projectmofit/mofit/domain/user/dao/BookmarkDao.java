package projectmofit.mofit.domain.user.dao;

import projectmofit.mofit.domain.user.dto.Bookmark;

import java.util.*;

public interface BookmarkDao {

    int bookmark(Bookmark bookmark);

    List<Bookmark> findBookmark(int userId);


}

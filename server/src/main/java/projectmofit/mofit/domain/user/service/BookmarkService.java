package projectmofit.mofit.domain.user.service;

import projectmofit.mofit.domain.user.dto.Bookmark;

import java.util.*;

public interface BookmarkService {

    int bookmark(Bookmark bookmark);

    List<Bookmark> getBookmark(int userId);
}

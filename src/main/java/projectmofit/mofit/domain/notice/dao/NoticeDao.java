package projectmofit.mofit.domain.notice.dao;

import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.notice.dto.Notice;

import java.util.List;

public interface NoticeDao {
    List<Notice> selectAll(int groupId);
    Notice selectOne(int index);
    int insertNotice(Notice notice);
    void updateNotice(Notice notice);
    int deleteNotice(int index);
}

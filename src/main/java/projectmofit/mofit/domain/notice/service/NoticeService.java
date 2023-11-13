package projectmofit.mofit.domain.notice.service;

import projectmofit.mofit.domain.board.dto.Board;
import projectmofit.mofit.domain.notice.dto.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotice(int groupId);
    Notice getNoticeByGroupId(int groupId, int index);
    int addNotice(Notice notice);
    void editNotice(Notice notice);
    int removeNotice(int groupId, int index);
}

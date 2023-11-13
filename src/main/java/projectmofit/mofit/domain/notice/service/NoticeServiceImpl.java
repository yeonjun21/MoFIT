package projectmofit.mofit.domain.notice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projectmofit.mofit.domain.notice.dao.NoticeDao;
import projectmofit.mofit.domain.notice.dto.Notice;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeDao noticeDao;
    @Override
    public List<Notice> getNotice(int groupId) {
        List<Notice> list = noticeDao.selectAll(groupId);
        return list;
    }

    @Override
    public Notice getNoticeByGroupId(int groupId, int index) {
        Notice notice = noticeDao.selectOne(groupId, index);
        return notice;
    }

    @Override
    public int addNotice(Notice notice) {
        int result = noticeDao.insertNotice(notice);
        return result;
    }

    @Override
    public void editNotice(Notice notice) {
        noticeDao.updateNotice(notice);
    }

    @Override
    public int removeNotice(int groupId, int index) {
        int result = noticeDao.deleteNotice(groupId, index);
        return result;
    }
}

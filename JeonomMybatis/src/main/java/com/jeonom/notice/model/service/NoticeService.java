package com.jeonom.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jeonom.common.SqlSessionTemplate;
import com.jeonom.notice.model.dao.NoticeDAO;
import com.jeonom.notice.model.vo.Notice;

public class NoticeService {
	
	private SqlSession session;
	private NoticeDAO nDao; 
	
	public NoticeService() {
		nDao = new NoticeDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(session, notice);
		return result;
	}

	public List<Notice> selectAllNotice() {
		List<Notice> nList = nDao.selectList(session);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.selectOneByNo(session, noticeNo);
		return notice;
	}

	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(session, notice);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(session, noticeNo);
		return result;
	}

}

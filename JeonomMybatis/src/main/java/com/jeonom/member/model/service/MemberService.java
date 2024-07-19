package com.jeonom.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.jeonom.common.SqlSessionTemplate;
import com.jeonom.member.model.dao.MemberDAO;
import com.jeonom.member.model.vo.Member;

public class MemberService {
	
	private SqlSession conn;
	private MemberDAO mDao;
	
	public MemberService() {
		conn = SqlSessionTemplate.getSqlSession();
		mDao = new MemberDAO();
	}
	
	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		return result;
	}

	public int updateMember(Member member) {
		int result = mDao.updateMember(conn, member);
		return result;
	}

	public int deleteMember(String memberId) {
		int result = mDao.deleteMember(conn, memberId);
		return result;
	}

	public Member checkLogin(Member member) {
		Member mOne = mDao.checkLogin(conn, member);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}

}

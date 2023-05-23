package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

// MyBatis DAO 정의
public class MyMemberDAO {
	// SqlSessionFactory 생성 : DB관련 기능을 직접 사용할 수 있는 세션을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	// 회원가입
	public int join(MyMember member) {
		// Factory 사용해서 Session 생성
		// true : auto commit(default->false)
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			// insert(실제 실행 할 sql-namespace(xml),sql 실행할 때 넘겨줄 값(?))
			// 반환값 : sql 실행 성공(삽입 성공->1 / 실패->0)
			cnt = sqlSession.insert("MyMemberDAO.insert",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); // 자원 반환
		}
		return cnt;
	}
	
	// 로그인
	public MyMember login(MyMember member) {
		MyMember member2 = null;
		// 세션 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			member2 = sqlSession.selectOne("MyMemberDAO.login",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member2;
		
	}
	
}

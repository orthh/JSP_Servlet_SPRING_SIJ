package com.smhrd.database;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 데이터베이스 연결, sql 실행 등의 역할
public class SqlSessionManager {
	// 실제 연결, 실행 등에 역할을 수행할 session 생성해주는 factory(session: DB연결,종료 등 역할)
	public static SqlSessionFactory sqlSessionFactory;
	
   //클래스 초기화 블럭 : 클래스가 처음 로딩될 때 딱 한번만 수행
   static {
      //설정정보 가지고 오기위한 mybatis-config.xml 경로 작성
      String resource = "com/smhrd/database/mybatis-config.xml";

      Reader reader;
      try {
         //문자열 경로로 파일읽기
         reader = Resources.getResourceAsReader(resource);
         //읽은 정보를 토대로 DB 관련 기능을 가진 SqlSessionFactory 생성
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   // static 초기화 블럭에서 생성된 factory 반환
   public static SqlSessionFactory getSqlSessionFactory() {
	   return sqlSessionFactory;
   }
	
}

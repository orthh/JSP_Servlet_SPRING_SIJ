package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 모든 클래스들은 Command 구현 : 기능 호출시 process() 메소드를 호출할 수 있도록 강제성 부여!
	// 추상메소드, 상수
	
	// String : process 메소드내에 기능 모두 수행한 후 최종적으로 이동해야하는 페이지 경로
	public String process(HttpServletRequest request, HttpServletResponse response);
}

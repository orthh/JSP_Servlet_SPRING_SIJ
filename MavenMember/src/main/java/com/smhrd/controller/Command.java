package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 컨트롤러가 구현할 인터페이스
public interface Command {
	// 모든 컨트롤러가 process 메소드를 오버라이딩 할 수 있게 강제성 부여!
	// 반환 : 최종적으로 이동해야하는 페이지의 이름
	// 메소드 이름 : process
	// request, response 객체를 매개인자로 넣어줘야함!
	public String process(HttpServletRequest request, HttpServletResponse response);
}

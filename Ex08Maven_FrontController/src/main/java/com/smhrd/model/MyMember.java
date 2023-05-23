package com.smhrd.model;

public class MyMember {
	private String id;
	private String pw;
	private String nick;
	
	public MyMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public MyMember(String id, String pw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNick() {
		return nick;
	}
	
}

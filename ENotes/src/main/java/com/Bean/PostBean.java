package com.Bean;

import java.sql.Date;

public class PostBean {
	
	private int id;
	private String title;
	private String content;
	private Date pdate;
	private UserBean use;
	public PostBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostBean(int id, String title, String content, Date pdate, UserBean use) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pdate = pdate;
		this.use = use;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public UserBean getUse() {
		return use;
	}
	public void setUse(UserBean use) {
		this.use = use;
	}
	
	
}

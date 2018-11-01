package com.hpeu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * 
 * @author 姚臣伟
 */
public class User implements Serializable {
	private static final long serialVersionUID = -7641254412120940939L;
	private Integer id; // 主键
	private String name; // 姓名
	private String account; // 账号
	private String password; // 密码
	private String email; // 邮箱
	private String phone; // 电话
	private Date regtime; // 注册时间
	private String avator; // 头像

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public String getAvator() {
		return avator;
	}

	public void setAvator(String avator) {
		this.avator = avator;
	}

}

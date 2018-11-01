package com.hpeu.bean;

import java.io.Serializable;

/**
 * 部门实体类
 * 
 */
public class Department implements Serializable {
	private static final long serialVersionUID = 5731011468892750434L;
	private Integer id; // 编号
	private String departName; // 名称
	private String address; // 所在地

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName + ", address=" + address + "]";
	}

}

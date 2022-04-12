package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends BaseEntity{
	@Column(name ="name", columnDefinition = "nvarchar(255)")
	private String name;
	@Column(name ="role", columnDefinition = "nvarchar(50)")
	private String code;
	
	@ManyToMany(mappedBy = "roles")
    private List<AccountEntity> users = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<AccountEntity> getUsers() {
		return users;
	}
	public void setUsers(List<AccountEntity> users) {
		this.users = users;
	}
	
}

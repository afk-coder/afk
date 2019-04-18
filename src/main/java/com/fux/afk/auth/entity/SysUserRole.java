package com.fux.afk.auth.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_user_role")
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	@Column(name="role_id")
	private Integer roleId;

	@Column(name="user_id")
	private Integer userId;

	public SysUserRole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
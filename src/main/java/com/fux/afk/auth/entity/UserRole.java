package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="role_id")
	private Integer roleId;

	@Column(name="user_id")
	private Integer userId;

	public UserRole() {
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
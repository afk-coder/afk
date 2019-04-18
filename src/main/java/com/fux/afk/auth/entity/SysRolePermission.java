package com.fux.afk.auth.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_role_permission")
public class SysRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	@Column(name="permission_id")
	private Integer permissionId;

	@Column(name="role_id")
	private Integer roleId;

	public SysRolePermission() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_role_permission")
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="permission_id")
	private Integer permissionId;

	@Column(name="role_id")
	private Integer roleId;

	public RolePermission() {
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
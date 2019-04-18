package com.fux.afk.auth.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_role_dept")
public class SysRoleDept implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

	@Column(name="dept_id")
	private Integer deptId;

	@Column(name="role_id")
	private Integer roleId;

	public SysRoleDept() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
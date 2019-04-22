package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_role_dept")
public class SysRoleDept implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_role_dept_generator")
    @TableGenerator(name = "id_sys_role_dept_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_role_dept",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    @Column(name = "id", precision = 19, scale = 0)
    private BigDecimal id;

    @Column(name="dept_id", precision = 19, scale = 0)
	private BigDecimal deptId;

	@Column(name="role_id", precision = 19, scale = 0)
	private BigDecimal roleId;

	public SysRoleDept() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getDeptId() {
		return this.deptId;
	}

	public void setDeptId(BigDecimal deptId) {
		this.deptId = deptId;
	}

	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

}
package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_user_role")
public class SysUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_user_role_generator")
    @TableGenerator(name = "id_sys_user_role_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_user_role",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    @Column(name = "id")
    private BigDecimal id;

	@Column(name="role_id")
	private BigDecimal roleId;

	@Column(name="user_id")
	private BigDecimal userId;

	public SysUserRole() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

}
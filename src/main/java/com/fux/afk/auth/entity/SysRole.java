package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_role")
public class SysRole implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_role_generator")
    @TableGenerator(name = "id_sys_role_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_role",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    @Column(name = "id", precision = 19, scale = 0)
    private BigDecimal id;

    @Column(name="del_flag", length = 10)
	private String delFlag;

    @Column(name="remark", length = 100)
	private String remark;

	@Column(name="role_name", length = 50)
	private String roleName;

    @Column(name="sorting", precision = 19, scale = 0)
	private BigDecimal sorting;

    @Column(name="status", length = 10)
	private String status;

	public SysRole() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigDecimal getSorting() {
		return this.sorting;
	}

	public void setSorting(BigDecimal sorting) {
		this.sorting = sorting;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_dept")
public class SysDept implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_dept_generator")
    @TableGenerator(name = "id_sys_dept_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_dept",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    private BigDecimal id;

    /**
     * 删除标识 0 删除、 1 存在
     */
	@Column(name="del_flag", length = 10)
	private String delFlag;

    @Column(name="email", length = 50)
	private String email;

    @Column(name="leader", length = 50)
	private String leader;

    @Column(name="name", length = 50)
	private String name;

	@Column(name="parent_id")
	private BigDecimal parentId;

    @Column(name="phone", length = 20)
	private String phone;

	private BigDecimal sorting;

    /**
     * 部门状态 0 停用、1 正常
     */
    @Column(name="status", length = 10)
	private String status;

	public SysDept() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeader() {
		return this.leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getParentId() {
		return this.parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
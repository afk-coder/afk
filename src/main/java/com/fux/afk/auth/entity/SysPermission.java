package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_permission")
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_permission_generator")
    @TableGenerator(name = "id_sys_permission_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_permission",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    @Column(name = "id", precision = 19, scale = 0)
	private BigDecimal id;

    @Column(name="action", length = 50)
	private String action;

    @Column(name="code", length = 50)
	private String code;

    @Column(name="icon", length = 50)
	private String icon;

	@Column(name="is_button", precision = 19, scale = 0)
	private BigDecimal isButton;

	@Column(name="is_menu", precision = 19, scale = 0)
	private BigDecimal isMenu;

    @Column(name="name", length = 50)
	private String name;

	@Column(name="parent_id", precision = 19, scale = 0)
	private BigDecimal parentId;

    @Column(name="sorting", precision = 19, scale = 0)
	private BigDecimal sorting;

    @Column(name="type", length = 10)
	private String type;

	public SysPermission() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public BigDecimal getIsButton() {
		return this.isButton;
	}

	public void setIsButton(BigDecimal isButton) {
		this.isButton = isButton;
	}

	public BigDecimal getIsMenu() {
		return this.isMenu;
	}

	public void setIsMenu(BigDecimal isMenu) {
		this.isMenu = isMenu;
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

	public BigDecimal getSorting() {
		return this.sorting;
	}

	public void setSorting(BigDecimal sorting) {
		this.sorting = sorting;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
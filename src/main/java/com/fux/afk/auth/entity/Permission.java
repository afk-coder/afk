package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="is_button")
	private Integer isButton;

	@Column(name="is_menu")
	private Integer isMenu;

	private String name;

	@Column(name="parent_id")
	private Integer parentId;

	private Integer sorting;

	private String action;

	private String code;

	public Permission() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsButton() {
		return this.isButton;
	}

	public void setIsButton(Integer isButton) {
		this.isButton = isButton;
	}

	public Integer getIsMenu() {
		return this.isMenu;
	}

	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSorting() {
		return this.sorting;
	}

	public void setSorting(Integer sorting) {
		this.sorting = sorting;
	}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
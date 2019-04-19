package com.fux.afk.auth.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by fuxj on 2019/3/6
 */
@Entity
@Table(name="sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_sys_user_generator")
    @TableGenerator(name = "id_sys_user_generator",
            table = "sys_identity",
            pkColumnName = "table_name",
            pkColumnValue = "sys_user",
            valueColumnName = "next_increment_val",
            initialValue = 10000000, allocationSize = 1)
    private BigDecimal id;

    @Column(name="avatar", length = 50)
	private String avatar;

	@Column(name="create_time")
	private Date createTime;

	@Column(name="dept_id")
	private BigDecimal deptId;

    @Column(name="email", length = 20)
	private String email;

	@Column(name="is_enabled", length = 20)
	private String isEnabled;

	@Column(name="login_ip", length = 20)
	private String loginIp;

	@Column(name="login_time")
	private Date loginTime;

    @Column(name="name", length = 20)
	private String name;

    @Column(name="password", length = 20)
	private String password;

    @Column(name="phone", length = 20)
	private String phone;

    @Column(name="real_name", length = 50)
	private String realName;

    @Column(name="salt", length = 50)
	private String salt;

    @Column(name="sex", length = 10)
	private String sex;

	@Column(name="update_time")
	private Date updateTime;

	@Column(name="user_type")
	private String userType;

	public SysUser() {
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getDeptId() {
		return this.deptId;
	}

	public void setDeptId(BigDecimal deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
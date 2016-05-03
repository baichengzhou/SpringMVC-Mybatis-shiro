package com.sojson.common.model;

import java.io.Serializable;
import java.util.Date;

public class SOUser implements Serializable{
	private static final long serialVersionUID = 1211026945769811L;

	private Long id;

    private String nickname;/**昵称*/

    private String email;/**邮箱*/

    private String portrait;/**头像*/

    private String password;/**密码*/

    private String security;/**密钥*/

    private Date createTime;/**创建时间*/

    private Date lastLoginTime;/**最后登录时间*/
    
    private String job;/**职业*/
    
    private String address;/**地址*/
    
    private String intro;/**个人描述*/
    
    private String link;/**主页地址*/
    private String qq;/**qq号码*/
    
    private Long level;/**0:普通用户，1：能发布博客，8：管理员*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
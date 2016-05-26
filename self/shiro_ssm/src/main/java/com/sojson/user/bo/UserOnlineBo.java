package com.sojson.user.bo;

import java.io.Serializable;
import java.util.Date;

import com.sojson.common.model.UUser;

public class UserOnlineBo extends UUser implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String sessionId;
	
	private String host;
	
	private Date startTime;
	
	private Date lastAccess;
	
	private long timeout;
	
	public UserOnlineBo() {
	}
	
	public UserOnlineBo(UUser user) {
		super(user);
	}
	
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	

}

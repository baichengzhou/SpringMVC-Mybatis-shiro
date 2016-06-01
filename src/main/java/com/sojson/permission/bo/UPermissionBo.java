package com.sojson.permission.bo;

import java.io.Serializable;

import com.sojson.common.model.UPermission;

/**
 * 
 * 权限选择
 * @author zhou-baicheng
 *
 */
public class UPermissionBo extends UPermission implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 是否勾选
	 */
	private String marker;

	public boolean isCheck(){
		return (String.valueOf(super.getId())).equals(marker);
	}
	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}
	
}

package com.lawyer.cores.shiro.session;

import java.io.Serializable;

/**
 * 
 * 开发公司：lawyer在线工具 <p>
 * 版权所有：© www.lawyer.com<p>
 * 博客地址：http://www.lawyer.com/blog/  <p>
 * <p>
 * 
 * Session 状态 VO
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @email  so@lawyer.com
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class SessionStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	//是否踢出 true:有效，false：踢出。
	private Boolean onlineStatus = Boolean.TRUE;

	
	public Boolean isOnlineStatus(){
		return onlineStatus;
	}

	public Boolean getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	
	
}

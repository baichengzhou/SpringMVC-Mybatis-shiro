package com.sojson.core.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * 用户session操作
 *
 * @author zhoubaicheng
 */
public interface ShiroSessionRepository {

	/**
	 * 存储Session
	 * @param session
	 */
    void saveSession(Session session);
    /**
     * 删除session
     * @param sessionId
     */
    void deleteSession(Serializable sessionId);
    /**
     * 获取session
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);
    /**
     * 获取所有sessoin
     * @return
     */
    Collection<Session> getAllSessions();
}

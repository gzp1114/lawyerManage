package com.lawyer.cores.shiro;

import java.io.Serializable;
import java.util.Collection;

import org.apache.ibatis.annotations.Insert;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import com.lawyer.common.utils.LoggerUtils;
import com.lawyer.cores.shiro.session.ShiroSessionRepository;
/**
 * Session 操作
 * @author guozhipeng
 *
 */
public class CustomShiroSessionDAO extends AbstractSessionDAO{ 
	
    private ShiroSessionRepository shiroSessionRepository;  
  
    public ShiroSessionRepository getShiroSessionRepository() {  
        return shiroSessionRepository;  
    }  
  
    public void setShiroSessionRepository(  
            ShiroSessionRepository shiroSessionRepository) {  
        this.shiroSessionRepository = shiroSessionRepository;  
    }  
  
    @Override  
    public void update(Session session) throws UnknownSessionException {  
        getShiroSessionRepository().saveSession(session);  
    }  
  
    @Override  
    public void delete(Session session) {  
        if (session == null) {  
        	LoggerUtils.error(getClass(), "Session 不能为null");
            return;  
        }  
        Serializable id = session.getId();  
        if (id != null)  
            getShiroSessionRepository().deleteSession(id);  
    }  
  
    @Override  
    public Collection<Session> getActiveSessions() {  
        return getShiroSessionRepository().getAllSessions();  
    }  
  
    @Override  
    protected Serializable doCreate(Session session) {  
        Serializable sessionId = this.generateSessionId(session);  
        this.assignSessionId(session, sessionId);  
        getShiroSessionRepository().saveSession(session);  
        return sessionId;  
    }  
  
    @Override  
    protected Session doReadSession(Serializable sessionId) {  
        return getShiroSessionRepository().getSession(sessionId);  
    } }

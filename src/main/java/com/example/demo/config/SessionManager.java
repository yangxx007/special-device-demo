package com.example.demo.config;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * Created by yang on 2017/9/9.
 */
public class SessionManager extends DefaultWebSessionManager{


    public SessionManager() {

        super();
        System.out.println("sessionmanager");
    }

    @Override
    public Cookie getSessionIdCookie() {
        System.out.println("GETSESSIONIDCOOKIE");
        return super.getSessionIdCookie();
    }

    @Override
    public void setSessionIdCookie(Cookie sessionIdCookie) {
        System.out.println("SETSESSIONIDCOOKIE");
        super.setSessionIdCookie(sessionIdCookie);
    }

    @Override
    public boolean isSessionIdCookieEnabled() {
        System.out.println("ISSESSIONIDCOOKIE");
        return super.isSessionIdCookieEnabled();
    }

    @Override
    public void setSessionIdCookieEnabled(boolean sessionIdCookieEnabled) {
        System.out.println("SETSESSIONCOOOKIE");
        super.setSessionIdCookieEnabled(sessionIdCookieEnabled);
    }

    @Override
    public boolean isSessionIdUrlRewritingEnabled() {
        System.out.println("ISSESSIONIDURL");
        return super.isSessionIdUrlRewritingEnabled();
    }

    @Override
    public void setSessionIdUrlRewritingEnabled(boolean sessionIdUrlRewritingEnabled) {
        System.out.println("SETSESSIONIDURL");
        super.setSessionIdUrlRewritingEnabled(sessionIdUrlRewritingEnabled);
    }

    @Override
    protected Session createExposedSession(Session session, SessionContext context) {
        System.out.println("CREATEEXPOSED");
        return super.createExposedSession(session, context);
    }

    @Override
    protected Session createExposedSession(Session session, SessionKey key) {
        System.out.println("CREATEEXPOSEDSESSION");
        return super.createExposedSession(session, key);
    }

    @Override
    protected void onStart(Session session, SessionContext context) {
        System.out.println("ONSTART");
        super.onStart(session, context);
    }

    @Override
    public Serializable getSessionId(SessionKey key) {
        System.out.println("GETSESSIONID");
        return super.getSessionId(key);
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        System.out.println("GETSESSIONID");
        return super.getSessionId(request, response);
    }


}
